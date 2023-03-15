package victorpuiu.realestateapp.dto;


import lombok.Getter;
import lombok.Setter;
import victorpuiu.realestateapp.entity.AdvertisementType;
import victorpuiu.realestateapp.entity.ProductType;

/**
 * The resource representing a property.
 */

@Getter
@Setter
public class ProductDto {

    private Long id;

    private ProductType propertyType;

    private String description;

    private double price;

    private AddressDto address;

    private AdvertisementType advertisementType;

    private String image;

}
