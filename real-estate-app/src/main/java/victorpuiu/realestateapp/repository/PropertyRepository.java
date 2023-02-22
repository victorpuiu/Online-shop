package victorpuiu.realestateapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import victorpuiu.realestateapp.entity.Property;

import java.util.List;


/**
 * The database connection with basic CRUD capabilities to the properties table.
 *
 */

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {


    List<Property> findByPriceLessThanOrEqual(Double max);

    List<Property> findByPriceGreaterThanOrEqual(Double min);

    List<Property> findByPriceBetween(Double min, Double max);
}
