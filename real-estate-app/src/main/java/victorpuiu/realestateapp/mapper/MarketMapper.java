package victorpuiu.realestateapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import victorpuiu.realestateapp.dto.MarketDto;
import victorpuiu.realestateapp.entity.Market;

@Mapper
public interface MarketMapper {
    MarketMapper INSTANCE = Mappers.getMapper(MarketMapper.class);



    MarketDto toMarketDto(Market market);



    Market toMarket(MarketDto marketDto);


}
