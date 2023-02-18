package victorpuiu.realestateapp.service;

import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.model.LoginRequest;

public interface LoginService {

    UserDto login(LoginRequest loginRequest);


}
