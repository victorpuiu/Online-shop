package victorpuiu.realestateapp.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MarketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Market market;

    @OneToMany(mappedBy = "marketCategory")
    private List<Product> products = new ArrayList<>();

}
