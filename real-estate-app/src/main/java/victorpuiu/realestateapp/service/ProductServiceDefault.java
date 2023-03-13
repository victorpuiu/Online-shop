package victorpuiu.realestateapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import victorpuiu.realestateapp.dto.ProductDto;
import victorpuiu.realestateapp.entity.Product;
import victorpuiu.realestateapp.mapper.ProductMapper;
import victorpuiu.realestateapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductServiceDefault implements ProductService {

    public static final String DEFAULT_PRICE = "0.00";

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceDefault.class);


    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceDefault(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto findById(long id) {
       Optional<Product> propertyOptional = productRepository.findById(id);
       return propertyOptional.map(ProductMapper.INSTANCE::toProductDto)
               .orElseThrow(() -> new IllegalArgumentException("Id does not exist"));

    }


    @Override
    public void deleteById(long id) {
        // Check if the property exists
        Optional<Product> optionalProperty = productRepository.findById(id);
        if (!optionalProperty.isPresent()){
            throw new IllegalArgumentException("Property does not exist");
        }
        // Delete the property
        Product product = optionalProperty.get();
        productRepository.delete(product);
    }


    @Override
    public List<ProductDto> getProducts(Double min, Double max) {
        min = min == null ? min = 0d : min;
        max = max == null ? max = (double)Integer.MAX_VALUE : max;

        return productRepository.findByPriceBetween(min, max).stream().map(property ->
                ProductMapper.INSTANCE.toProductDto(property)).collect(Collectors.toList());
    }
}
