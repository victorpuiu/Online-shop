package victorpuiu.realestateapp.service;

import victorpuiu.realestateapp.dto.PropertyDto;

import java.util.List;

public interface PropertyService {

   PropertyDto findById(long id);

   void deleteProperty(long id);


   List<PropertyDto> getProperties(Double min, Double max);

}
