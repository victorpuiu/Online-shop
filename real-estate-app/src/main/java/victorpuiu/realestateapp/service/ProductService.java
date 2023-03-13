package victorpuiu.realestateapp.service;

import victorpuiu.realestateapp.dto.ProductDto;

import java.util.List;

public interface ProductService {

   ProductDto findById(long id);

   void deleteById(long id);


   List<ProductDto> getProducts(Double min, Double max);

}
