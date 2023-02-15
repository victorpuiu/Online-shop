package victorpuiu.realestateapp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import victorpuiu.realestateapp.dto.LoginDto;
import victorpuiu.realestateapp.entity.User;
import victorpuiu.realestateapp.exception.AuthException;
import victorpuiu.realestateapp.model.LoginRequest;
import victorpuiu.realestateapp.repository.LoginRepository;

import java.util.Optional;

@Service
@Profile({"dummy"})
@Primary
public class LoginServiceDummy implements LoginService {

    private final LoginRepository loginRepository;

    public LoginServiceDummy(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public LoginDto login(LoginRequest loginRequest) {

        Optional<User> userOptional = this.loginRepository.findByUsername(loginRequest.getUsername());
        //TODO hash the frontend password and then compare with the saved password

        User user = userOptional.orElseThrow(() -> new IllegalStateException("No user found!"));
        if (!loginRequest.getPassword().equals(user.getPassword())){
            throw new AuthException(HttpStatus.UNAUTHORIZED, "Incorrect Pass");
        }

        return null;
    }


}
