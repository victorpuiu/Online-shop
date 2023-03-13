package victorpuiu.realestateapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import victorpuiu.realestateapp.dto.ProductDto;
import victorpuiu.realestateapp.entity.Product;


@Mapper
public interface PropertyMapper {
    PropertyMapper INSTANCE = Mappers.getMapper(PropertyMapper.class);

    ProductDto toPropertyDto(Product product);

    Product toProperty(ProductDto productDto);


}
