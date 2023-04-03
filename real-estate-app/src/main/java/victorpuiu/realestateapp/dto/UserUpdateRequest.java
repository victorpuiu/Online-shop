package victorpuiu.realestateapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {

    private Long id;
    private String userName;

    private String email;
    private String password;
}
