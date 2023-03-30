package victorpuiu.realestateapp.mapper;

import javax.annotation.processing.Generated;
import victorpuiu.realestateapp.dto.AddressDto;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.dto.ProductDto;
import victorpuiu.realestateapp.entity.Address;
import victorpuiu.realestateapp.entity.MarketCategory;
import victorpuiu.realestateapp.entity.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-28T02:01:19+0300",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
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

        product.setMarketCategory( marketCategoryDtoToMarketCategory( productDto.getMarketCategoryDto() ) );
        product.setId( productDto.getId() );
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

    protected MarketCategory marketCategoryDtoToMarketCategory(MarketCategoryDto marketCategoryDto) {
        if ( marketCategoryDto == null ) {
            return null;
        }

        MarketCategory marketCategory = new MarketCategory();

        marketCategory.setId( marketCategoryDto.getId() );
        marketCategory.setName( marketCategoryDto.getName() );
        marketCategory.setImageUrl( marketCategoryDto.getImageUrl() );
        marketCategory.setRedirectLink( marketCategoryDto.getRedirectLink() );

        return marketCategory;
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
