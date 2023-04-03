package victorpuiu.realestateapp.service;

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
public class LoginServiceDefault implements LoginService {

    private final UserRepository userRepository;

    public LoginServiceDefault(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto login(LoginRequest loginRequest) {

        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getEmail());
        User user = optionalUser.orElseThrow(() -> new IllegalStateException("No user found"));

//        String hashedPassword = hashPassword(loginRequest.getPassword());

        String password = loginRequest.getPassword();
        if (!password.equals(user.getPassword())){
            throw new AuthException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }

        return UserMapper.toUserDto(user);
    }

//    private String hashPassword(String password) {
//        // Hash the password using the bcrypt algorithm with default cost factor
//        return BCrypt.hashpw(password, BCrypt.gensalt());
//    }


}
