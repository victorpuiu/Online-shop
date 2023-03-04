package victorpuiu.realestateapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import victorpuiu.realestateapp.dto.PropertyDto;
import victorpuiu.realestateapp.entity.Property;
import victorpuiu.realestateapp.mapper.PropertyMapper;
import victorpuiu.realestateapp.repository.PropertyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PropertyServiceDefault implements PropertyService {

    public static final String DEFAULT_PRICE = "0.00";

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyServiceDefault.class);


    private final PropertyRepository propertyRepository;


    @Autowired
    public PropertyServiceDefault(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyDto findById(long id) {
       Optional<Property> propertyOptional = propertyRepository.findById(id);
       return propertyOptional.map(PropertyMapper.INSTANCE::toPropertyDto)
               .orElseThrow(() -> new IllegalArgumentException("Id does not exist"));

    }


    @Override
    public void deleteProperty(long id) {
        // Check if the property exists
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if (!optionalProperty.isPresent()){
            throw new IllegalArgumentException("Property does not exist");
        }
        // Delete the property
        Property property = optionalProperty.get();
        propertyRepository.delete(property);
    }


    @Override
    public List<PropertyDto> getProperties(Double min, Double max) {
        min = min == null ? min = 0d : min;
        max = max == null ? max = (double)Integer.MAX_VALUE : max;

        return propertyRepository.findByPriceBetween(min, max).stream().map(property ->
                PropertyMapper.INSTANCE.toPropertyDto(property)).collect(Collectors.toList());
    }
}
