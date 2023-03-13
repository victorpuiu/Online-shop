package victorpuiu.realestateapp.service;

import victorpuiu.realestateapp.dto.ProductDto;

import java.util.List;

public interface PropertyService {

   ProductDto findById(long id);

   void deleteProperty(long id);


   List<ProductDto> getProperties(Double min, Double max);

}
