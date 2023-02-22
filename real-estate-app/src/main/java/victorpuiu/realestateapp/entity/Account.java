package victorpuiu.realestateapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

/**
 * The account resource with specified user details
 */
@Entity(name = "account")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastName;

    @Email
    private String email;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    private Permission permission;

    @CreatedDate
    private Timestamp createdAt;



}


















