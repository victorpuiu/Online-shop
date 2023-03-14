package victorpuiu.realestateapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import victorpuiu.realestateapp.entity.MarketCategory;


@Repository
public interface MarketCategoryRepository extends JpaRepository<MarketCategory, Long> {
}
