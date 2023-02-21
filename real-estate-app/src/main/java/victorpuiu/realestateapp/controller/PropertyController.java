package victorpuiu.realestateapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import victorpuiu.realestateapp.dto.PropertyDto;
import victorpuiu.realestateapp.service.PropertyService;

import java.util.List;

@Controller
@RequestMapping("properties")
public class PropertyController {

    private final PropertyService service;

    @Autowired
    public PropertyController(PropertyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PropertyDto>> getAllProperties(
            @RequestParam(required = false) final Double min,
            @RequestParam(required = false) final Double max) {
        return null;
    }

    @GetMapping("property/{id}")
    public ResponseEntity<PropertyDto> getProperty(@PathVariable long id){
        return null;
    }

    @PostMapping("property/saveOrEdit")
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto){
        return null;
    }

}
