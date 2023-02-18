package victorpuiu.realestateapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.model.LoginRequest;
import victorpuiu.realestateapp.service.LoginService;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest loginRequest){
        UserDto userDto = this.loginService.login(loginRequest);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
