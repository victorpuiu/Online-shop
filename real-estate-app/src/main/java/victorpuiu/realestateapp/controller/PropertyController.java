package victorpuiu.realestateapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import victorpuiu.realestateapp.dto.ProductDto;
import victorpuiu.realestateapp.entity.Product;
import victorpuiu.realestateapp.mapper.PropertyMapper;
import victorpuiu.realestateapp.repository.PropertyRepository;
import victorpuiu.realestateapp.service.PropertyServiceDefault;

import java.util.List;

@Controller
@RequestMapping("properties")
public class PropertyController {

    private final PropertyServiceDefault service;
    private final PropertyRepository propertyRepository;
    private final PropertyMapper propertyMapper;

    @Autowired
    public PropertyController(PropertyServiceDefault service,
                              PropertyRepository propertyRepository,
                              PropertyMapper propertyMapper) {
        this.service = service;
        this.propertyRepository = propertyRepository;
        this.propertyMapper = propertyMapper;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProperties(
            @RequestParam(required = false) final Double min,
            @RequestParam(required = false) final Double max)
    {

        // Convert the Property objects to PropertyDto objects
        List<ProductDto> productDtos = service.getProperties(min, max);

        // Return a ResponseEntity with the list of PropertyDto objects and a 200 OK status code
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("property/{id}")
    public ResponseEntity<ProductDto> getProperty(@PathVariable long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("property/saveOrEdit")
    public ResponseEntity<ProductDto> createProperty(@RequestBody ProductDto productDto){
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
        Product product = PropertyMapper.INSTANCE.toProperty(productDto);

        // Save the property to the database
        //Need refactor because i used directly the propertyRepository and not service
        Product savedProduct = propertyRepository.save(product);

        // Map the saved property back to a DTO and return it
        ProductDto savedProductDto = PropertyMapper.INSTANCE.toPropertyDto(savedProduct);

        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
    }

    //The method returns a ResponseEntity<Void> with a 204 No Content status code if the
    // property is deleted successfully, or a 404 Not Found status code if the property is
    // not found.
    @DeleteMapping("property/delete/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable("id") Long id ){
        try {
            service.deleteProperty(id);
            //HTTP status code of 404 (Not Found)
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException exception){
            //HTTP response with a status code of 204 (No Content).
            return ResponseEntity.notFound().build();
        }
    }

}
