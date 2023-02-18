package victorpuiu.realestateapp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.entity.User;
import victorpuiu.realestateapp.exception.AuthException;
import victorpuiu.realestateapp.mapper.UserMapper;
import victorpuiu.realestateapp.model.LoginRequest;
import victorpuiu.realestateapp.repository.UserRepository;

import java.util.Optional;

@Service
@Profile({"dummy"})
@Primary
public class LoginServiceDummy implements LoginService {

    private final UserRepository userRepository;

    public LoginServiceDummy(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto login(LoginRequest loginRequest) {

        Optional<User> userOptional = this.userRepository.findByUsername(loginRequest.getUsername());
        //TODO hash the frontend password and then compare with the saved password

        User user = userOptional.orElseThrow(() -> new IllegalStateException("No user found!"));
        if (!loginRequest.getPassword().equals(user.getPassword())){
            throw new AuthException(HttpStatus.UNAUTHORIZED, "Incorrect Pass");
        }

        return UserMapper.toUserDto(user);
    }


}
