package victorpuiu.realestateapp.entity;

import jakarta.persistence.*;
import lombok.*;


/**
 * The address resource
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String country;

    private String city;

    private String street;

    private String zipcode;

    private String number;

    @OneToOne(mappedBy = "address")
    private Property property;

}
