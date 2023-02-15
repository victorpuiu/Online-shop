package victorpuiu.realestateapp.repository;


import victorpuiu.realestateapp.entity.User;

import java.util.Optional;

public interface LoginRepository {

    Optional<User> findByUsername(String username);


}
