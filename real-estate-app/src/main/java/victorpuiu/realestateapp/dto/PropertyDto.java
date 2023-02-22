package victorpuiu.realestateapp.dto;


import lombok.Getter;
import lombok.Setter;
import victorpuiu.realestateapp.entity.PropertyType;

/**
 * The resource representing a property.
 */

@Getter
@Setter
public class PropertyDto {

    private PropertyType propertyType;

    private String description;

    private double price;

    private AddressDto address;

    private String advertisementType;

    private String image;

}
