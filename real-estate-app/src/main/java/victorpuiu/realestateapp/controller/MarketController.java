package victorpuiu.realestateapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import victorpuiu.realestateapp.dto.MarketDto;
import victorpuiu.realestateapp.service.MarketService;

import java.util.List;

@Controller
@RequestMapping("markets")
@CrossOrigin("http://localhost:3000/markets")
public class MarketController {

    private final MarketService marketService;


    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }


    @GetMapping()
    public ResponseEntity<List<MarketDto>> getAllMarkets() {
        List<MarketDto> markets = marketService.getMarkets();

        return ResponseEntity.ok(markets);
    }

    @GetMapping("id")
    public ResponseEntity<MarketDto> getMarket(@PathVariable long id) {
        MarketDto market = marketService.findById(id);
        if (market == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(market);
    }

    @PostMapping("saveOrEdit")
    public ResponseEntity<MarketDto> createMarket(@RequestBody MarketDto marketDto){

        MarketDto savedMarket = marketService.saveOrEdit(marketDto);

        return new ResponseEntity<>(savedMarket, HttpStatus.CREATED);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMarket(@PathVariable("id") Long id ) {
        marketService.deleteById(id);
        return ResponseEntity.noContent().build();

    }



    }