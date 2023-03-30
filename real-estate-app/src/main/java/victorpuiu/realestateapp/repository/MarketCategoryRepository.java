package victorpuiu.realestateapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import victorpuiu.realestateapp.entity.MarketCategory;

import java.util.List;


@Repository
public interface MarketCategoryRepository extends JpaRepository<MarketCategory, Long> {
    List<MarketCategory> findByMarketId(long marketId);
}
