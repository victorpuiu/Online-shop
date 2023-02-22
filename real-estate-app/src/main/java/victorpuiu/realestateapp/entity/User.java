package victorpuiu.realestateapp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user_")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private String username;
    @Column
    private String password;






}
