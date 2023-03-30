package victorpuiu.realestateapp.service;

import org.springframework.stereotype.Service;
import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.dto.UserUpdateRequest;

@Service
public interface UserService {
    UserDto getUserById(long id);

    UserDto updateUser(UserUpdateRequest request);
}
