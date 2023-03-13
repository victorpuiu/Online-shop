package victorpuiu.realestateapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import victorpuiu.realestateapp.entity.Product;

import java.util.List;


/**
 * The database connection with basic CRUD capabilities to the properties table.
 *
 */

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    List<Product> findByPriceLessThan(Double max);

    List<Product> findByPriceGreaterThan(Double min);

    List<Product> findByPriceBetween(Double min, Double max);
}
