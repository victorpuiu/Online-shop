package victorpuiu.realestateapp.repository;

import org.springframework.stereotype.Repository;
import victorpuiu.realestateapp.entity.User;

import java.util.Optional;

@Repository
public class LoginRepositoryDummy implements LoginRepository {


    @Override
    public Optional<User> findByUsername(String username) {
        User user = new User();
        user.setUsername("test");
        user.setId(1L);
        user.setPassword("testpassword");
        return Optional.of(user);
    }
}
