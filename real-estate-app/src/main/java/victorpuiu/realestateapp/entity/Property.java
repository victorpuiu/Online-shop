package victorpuiu.realestateapp.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Data
@Entity(name = "property")
public class Property {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private PropertyType propertyType;

    private String description;

    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private AdvertisementType advertisementType;

    private String image;

    @CreatedDate
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;







}















