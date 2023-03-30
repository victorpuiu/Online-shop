package victorpuiu.realestateapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import victorpuiu.realestateapp.dto.MarketCategoryDto;
import victorpuiu.realestateapp.dto.ProductDto;
import victorpuiu.realestateapp.service.ProductService;
import victorpuiu.realestateapp.service.ProductServiceDefault;

import java.util.List;

@Controller
@RequestMapping("markets/{marketId}/categories/{categoryId}/products")
@CrossOrigin(origins ="http://localhost:3000")

public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductServiceDefault productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts(
            @RequestParam(required = false) final Double min,
            @RequestParam(required = false) final Double max)
            // 2 path variable to add
    {

        // Convert the Property objects to PropertyDto objects
        List<ProductDto> productDtos = productService.getProducts(min, max);

        // Return a ResponseEntity with the list of PropertyDto objects and a 200 OK status code
        return ResponseEntity.ok(productDtos);
    }


//    @GetMapping()
//    public ResponseEntity<List<ProductDto>> getFirst10Products() {
//        List<ProductDto> productDtos = productService.getFirst10Products();
//        return ResponseEntity.ok(productDtos);
//    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("saveOrEdit")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto,
                                                    @PathVariable("marketId") long marketId){
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
//        Product product = ProductMapper.INSTANCE.toProduct(productDto);

        MarketCategoryDto marketCategoryDto = new MarketCategoryDto();
        marketCategoryDto.setMarketId(marketId);
        productDto.setMarketCategoryDto(marketCategoryDto);

        // Save the property to the database
        ProductDto savedProduct = productService.saveOrEdit(productDto);

        // Map the saved property back to a DTO and return it
//        ProductDto savedProductDto = ProductMapper.INSTANCE.toProductDto(savedProduct);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    //The method returns a ResponseEntity<Void> with a 204 No Content status code if the
    // property is deleted successfully, or a 404 Not Found status code if the property is
    // not found.
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id ){
        try {
            productService.deleteById(id);
            //HTTP status code of 404 (Not Found)
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException exception){
            //HTTP response with a status code of 204 (No Content).
            return ResponseEntity.notFound().build();
        }
    }

}
