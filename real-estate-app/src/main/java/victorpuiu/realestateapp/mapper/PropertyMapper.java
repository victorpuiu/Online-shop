package victorpuiu.realestateapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import victorpuiu.realestateapp.dto.PropertyDto;
import victorpuiu.realestateapp.entity.Product;


@Mapper
public interface PropertyMapper {
    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    PropertyDto toPropertyDto(Product product);

    Product toProperty(PropertyDto propertyDto);


}
