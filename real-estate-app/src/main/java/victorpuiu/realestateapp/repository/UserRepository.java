package victorpuiu.realestateapp.repository;


import victorpuiu.realestateapp.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);


}
