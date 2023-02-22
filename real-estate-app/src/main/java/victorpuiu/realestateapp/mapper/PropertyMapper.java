package victorpuiu.realestateapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import victorpuiu.realestateapp.dto.PropertyDto;
import victorpuiu.realestateapp.entity.Property;


@Mapper
public interface PropertyMapper {
    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    PropertyDto toPropertyDto(Property property);

    Property toProperty(PropertyDto propertyDto);


}
