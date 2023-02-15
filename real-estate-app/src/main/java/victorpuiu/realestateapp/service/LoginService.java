package victorpuiu.realestateapp.service;

import victorpuiu.realestateapp.dto.LoginDto;
import victorpuiu.realestateapp.model.LoginRequest;

public interface LoginService {

    LoginDto login(LoginRequest loginRequest);


}
