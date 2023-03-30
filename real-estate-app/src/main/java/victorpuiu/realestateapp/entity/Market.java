package victorpuiu.realestateapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "markets")
@Getter
@Setter
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String marketImageUrl;

    @OneToMany(mappedBy = "market")
    private List<MarketCategory> marketCategories =  new ArrayList<>();
}
