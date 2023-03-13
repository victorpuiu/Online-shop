package victorpuiu.realestateapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import victorpuiu.realestateapp.dto.ProductDto;
import victorpuiu.realestateapp.entity.Product;
import victorpuiu.realestateapp.mapper.ProductMapper;
import victorpuiu.realestateapp.repository.ProductRepository;
import victorpuiu.realestateapp.service.ProductServiceDefault;

import java.util.List;

@Controller
@RequestMapping("markets/{marketId}/categories/{categoryId}/products")
public class ProductController {

    private final ProductServiceDefault service;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductServiceDefault service,
                             ProductRepository productRepository,
                             ProductMapper productMapper) {
        this.service = service;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts(
            @RequestParam(required = false) final Double min,
            @RequestParam(required = false) final Double max)
    {

        // Convert the Property objects to PropertyDto objects
        List<ProductDto> productDtos = service.getProducts(min, max);

        // Return a ResponseEntity with the list of PropertyDto objects and a 200 OK status code
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("saveOrEdit")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        //validate the input
        if (productDto.getPropertyType() == null || productDto.getPropertyType().toString().isEmpty()){
            throw new IllegalArgumentException("Property cannot be empty");
        }
        if (productDto.getAddress() == null || productDto.getAddress().toString().isEmpty()){
            throw new IllegalArgumentException("Property address cannot be empty");
        }
        if (Double.isNaN(productDto.getPrice()) || productDto.getPrice() <= 0){
            throw new IllegalArgumentException("Property price must be a valid positive number");
        }
        // Map the DTO to a domain model
        Product product = ProductMapper.INSTANCE.toProduct(productDto);

        // Save the property to the database
        //Need refactor because i used directly the propertyRepository and not service
        Product savedProduct = productRepository.save(product);

        // Map the saved property back to a DTO and return it
        ProductDto savedProductDto = ProductMapper.INSTANCE.toProductDto(savedProduct);

        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
    }

    //The method returns a ResponseEntity<Void> with a 204 No Content status code if the
    // property is deleted successfully, or a 404 Not Found status code if the property is
    // not found.
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id ){
        try {
            service.deleteById(id);
            //HTTP status code of 404 (Not Found)
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException exception){
            //HTTP response with a status code of 204 (No Content).
            return ResponseEntity.notFound().build();
        }
    }

}
