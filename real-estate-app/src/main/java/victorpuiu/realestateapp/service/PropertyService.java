package victorpuiu.realestateapp.service;

import victorpuiu.realestateapp.dto.PropertyDto;
import victorpuiu.realestateapp.entity.Property;

import java.util.List;

public interface PropertyService {

   PropertyDto findById(long id);

   List<Property> getAllProperties();

   void deleteProperty(long id);

   List<Property> getPropertiesWithPriceLessThan(Double max);

   List<Property> getPropertiesWithPriceGreaterThan(Double min);

   List<Property> getPropertiesWithinPriceRange(Double min, Double max);

}
