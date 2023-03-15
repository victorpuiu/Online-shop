package victorpuiu.realestateapp.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import victorpuiu.realestateapp.dto.MarketDto;
import victorpuiu.realestateapp.entity.Market;
import victorpuiu.realestateapp.mapper.MarketMapper;
import victorpuiu.realestateapp.repository.MarketRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarketServiceDefault implements MarketService {

    private final MarketRepository marketRepository;


    public MarketServiceDefault(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @Override
    public List<MarketDto> getMarkets() {
        List<Market> markets = marketRepository.findAll();
        return markets.stream()
                .map(MarketMapper.INSTANCE::toMarketDto).collect(Collectors.toList());
    }

    @Override
    public MarketDto findById(long id) {
        Optional<Market> marketOptional = marketRepository.findById(id);
        return marketOptional.map(MarketMapper.INSTANCE::toMarketDto)
                .orElseThrow(() -> new IllegalArgumentException("Id does not exist"));
    }


    @Override
    public MarketDto saveOrEdit(MarketDto marketDto) {
        return marketRepository.findById(marketDto.getId() == null? 0 : marketDto.getId())
                .map(market -> edit(market, marketDto))
                .orElseGet(() -> save(marketDto));
    }

    @Transactional
    public MarketDto edit(Market market, MarketDto source){
        Market toEdit = MarketMapper.INSTANCE.toMarket(source);

        toEdit.setId(market.getId());
        return MarketMapper.INSTANCE.toMarketDto(marketRepository.save(toEdit));

    }

    @Transactional
    public MarketDto save(MarketDto marketDto){
        return MarketMapper.INSTANCE.toMarketDto(marketRepository.save(MarketMapper.INSTANCE.toMarket(marketDto)));
    }


    @Override
    public void deleteById(long id) {
        Optional<Market> marketOptional = marketRepository.findById(id);
        if (!marketOptional.isPresent()){
            throw new IllegalArgumentException("Market does not exist");
        }

        Market market = marketOptional.get();
        marketRepository.delete(market);

    }



}
