package victorpuiu.realestateapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.entity.MarketCategory;

@Mapper
public interface MarketCategoryMapper {

    MarketCategoryMapper INSTANCE = Mappers.getMapper(MarketCategoryMapper.class);

    @Mappings({
            @Mapping(target = "marketId", source = "market.id")
    })
    MarketCategoryDto toMarketCategoryDto(MarketCategory marketCategory);

    @Mappings({
            @Mapping(target = "market.id", source = "marketId")
    })
    MarketCategory toMarketCategory(MarketCategoryDto marketCategoryDto);

}
