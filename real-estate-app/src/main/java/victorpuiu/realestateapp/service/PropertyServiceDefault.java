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
import java.util.stream.StreamSupport;


@Service
public class PropertyServiceDefault implements PropertyService {


    public static final String DEFAULT_PRICE = "0.00";

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyServiceDefault.class);


    private final PropertyRepository repository;


    @Autowired
    public PropertyServiceDefault(PropertyRepository repository) {
        this.repository = repository;
    }

    @Override
    public PropertyDto findById(long id) {
       Optional<Property> propertyOptional = repository.findById(id);
       return propertyOptional.map(PropertyMapper.INSTANCE::toPropertyDto)
               .orElseThrow(() -> new IllegalArgumentException("Id does not exist"));

    }

    @Override
    public List<Property> getAllProperties() {
        Iterable<Property> proprietiesIterable = repository.findAll();
        List<Property> properties = StreamSupport.stream(proprietiesIterable.spliterator(), false)
                .collect(Collectors.toList());
        if (properties.isEmpty()) {
            throw new IllegalArgumentException("There are no property entries in the repository.");
        }
        LOGGER.info("Requesting all properties");
        return properties;

    }

    @Override
    public void deleteProperty(long id) {
        // Check if the property exists
        Optional<Property> optionalProperty = repository.findById(id);
        if (!optionalProperty.isPresent()){
            throw new IllegalArgumentException();
        }
        // Delete the property
        Property property = optionalProperty.get();
        repository.delete(property);
    }

    @Override
    public List<Property> getPropertiesWithPriceLessThanOrEqual(Double max) {
        return repository.findByPriceLessThanOrEqual(max);
    }

    @Override
    public List<Property> getPropertiesWithPriceGreaterThanOrEqual(Double min) {
        return repository.findByPriceGreaterThanOrEqual(min);
    }

    @Override
    public List<Property> getPropertiesWithinPriceRange(Double min, Double max) {
        return repository.findByPriceBetween(min, max);
    }
}
