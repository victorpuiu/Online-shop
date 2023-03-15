package victorpuiu.realestateapp.service;

import victorpuiu.realestateapp.dto.MarketDto;

import java.util.List;

public interface MarketService {

    MarketDto findById(long id);

    void deleteById(long id);


    List<MarketDto> getMarkets();

    MarketDto saveOrEdit(MarketDto marketDto);

}
