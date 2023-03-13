package victorpuiu.realestateapp.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import victorpuiu.realestateapp.dto.AddressDto;
import victorpuiu.realestateapp.dto.ProductDto;
import victorpuiu.realestateapp.entity.Address;
import victorpuiu.realestateapp.entity.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-23T20:49:32+0200",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setPropertyType( product.getPropertyType() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setAddress( addressToAddressDto( product.getAddress() ) );
        productDto.setAdvertisementType( product.getAdvertisementType() );
        productDto.setImage( product.getImage() );

        return productDto;
    }

    @Override
    public Product toProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setPropertyType( productDto.getPropertyType() );
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );
        product.setAddress( addressDtoToAddress( productDto.getAddress() ) );
        product.setAdvertisementType( productDto.getAdvertisementType() );
        product.setImage( productDto.getImage() );

        return product;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setCountry( address.getCountry() );
        addressDto.setCity( address.getCity() );
        addressDto.setStreet( address.getStreet() );
        addressDto.setZipcode( address.getZipcode() );
        addressDto.setNumber( address.getNumber() );

        return addressDto;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setCountry( addressDto.getCountry() );
        address.setCity( addressDto.getCity() );
        address.setStreet( addressDto.getStreet() );
        address.setZipcode( addressDto.getZipcode() );
        address.setNumber( addressDto.getNumber() );

        return address;
    }
}
