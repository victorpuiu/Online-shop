package victorpuiu.realestateapp.mapper;

import org.mapstruct.factory.Mappers;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.entity.MarketCategory;

public interface MarketCategoryMapper {

    MarketCategoryMapper INSTANCE = Mappers.getMapper(MarketCategoryMapper.class);

    MarketCategoryDto toMarketCategoryDto(MarketCategory marketCategory);

    MarketCategory toMarketCategory(MarketCategoryDto marketCategoryDto);

}
