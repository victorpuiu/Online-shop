package victorpuiu.realestateapp.service;


import victorpuiu.realestateapp.dto.MarketCategoryDto;

import java.util.List;

public interface MarketCategoryService {

    MarketCategoryDto findById(long id);

    void deleteById(long id);


    List<MarketCategoryDto> getCategories(long marketId);

    MarketCategoryDto saveOrEdit(MarketCategoryDto marketCategoryDto);


}
