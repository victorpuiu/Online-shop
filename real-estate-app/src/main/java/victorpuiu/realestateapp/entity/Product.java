package victorpuiu.realestateapp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import victorpuiu.realestateapp.model.AdvertisementType;
import victorpuiu.realestateapp.model.ProductType;

import java.sql.Timestamp;

@Entity(name = "product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private ProductType propertyType;

    private String description;

    private double price;

    @ManyToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private AdvertisementType advertisementType;

    private String image;

    @CreatedDate
    @UpdateTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;


    @ManyToOne
    private MarketCategory marketCategory;





}















