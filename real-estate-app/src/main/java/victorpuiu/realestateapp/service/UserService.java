package victorpuiu.realestateapp.service;

import org.springframework.stereotype.Service;
import victorpuiu.realestateapp.dto.UserDeleteRequest;
import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.dto.UserRegistrationRequest;
import victorpuiu.realestateapp.dto.UserUpdateRequest;

@Service
public interface UserService {
    UserDto getUserById(long id);

    UserDto updateUser(UserUpdateRequest request);

    UserDto createUser(UserRegistrationRequest request);

    void deleteUser(UserDeleteRequest request);
}
