package victorpuiu.realestateapp.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * The resource representing a property.
 */

@Getter
@Setter
public class PropertyDto {

    private String propertyType;

    private String description;

    private double price;

    private AddressDto address;

    private String advertisementType;

    private String image;

}
