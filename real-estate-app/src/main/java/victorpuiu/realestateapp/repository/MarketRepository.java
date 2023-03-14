package victorpuiu.realestateapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import victorpuiu.realestateapp.entity.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {



}
