package victorpuiu.realestateapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import victorpuiu.realestateapp.dto.MarketDto;
import victorpuiu.realestateapp.entity.Market;
import victorpuiu.realestateapp.mapper.MarketMapper;
import victorpuiu.realestateapp.service.MarketServiceDefault;

import java.util.List;

@Controller
@RequestMapping("markets")
public class MarketController {

    private final MarketServiceDefault marketServiceDefault;


    @Autowired
    public MarketController(MarketServiceDefault marketServiceDefault) {
        this.marketServiceDefault = marketServiceDefault;
    }


    @GetMapping
    public ResponseEntity<List<MarketDto>> getAllMarkets() {
        List<MarketDto> markets = marketServiceDefault.getMarkets();

        return ResponseEntity.ok(markets);
    }

    @GetMapping("id")
    public ResponseEntity<MarketDto> getMarket(@PathVariable long id) {
        MarketDto market = marketServiceDefault.findById(id);
        if (market == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(market);
    }

    @PostMapping("saveOrEdit")
    public ResponseEntity<MarketDto> createMarket(@RequestBody MarketDto marketDto){

        Market market = MarketMapper.INSTANCE.toMarket(marketDto);

        Market savedMarket = marketServiceDefault.saveMarket(market);
        MarketDto savedMarketDto = MarketMapper.INSTANCE.toMarketDto(savedMarket);

        return new ResponseEntity<>(savedMarketDto, HttpStatus.CREATED);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMarket(@PathVariable("id") Long id ) {
        marketServiceDefault.deleteById(id);
        return ResponseEntity.noContent().build();

    }



    }