package victorpuiu.realestateapp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import victorpuiu.realestateapp.model.ProductType;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Getter
@Setter
public class MarketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Market market;

    private List<ProductType> productTypes;

    private String name;

    private String imageUrl;

    private String redirectLink;

    @OneToMany(mappedBy = "marketCategory")
    private List<Product> products = new ArrayList<>();

}
