package victorpuiu.realestateapp.mapper;

import javax.annotation.processing.Generated;
import victorpuiu.realestateapp.dto.AddressDto;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.dto.ProductDto;
import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.entity.Address;
import victorpuiu.realestateapp.entity.MarketCategory;
import victorpuiu.realestateapp.entity.Product;
import victorpuiu.realestateapp.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T17:40:16+0300",
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
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setAddress( addressToAddressDto( product.getAddress() ) );
        productDto.setUser( userToUserDto( product.getUser() ) );
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
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );
        product.setUser( userDtoToUser( productDto.getUser() ) );
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

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );

        return userDto;
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

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setEmail( userDto.getEmail() );

        return user;
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
