package victorpuiu.realestateapp.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import victorpuiu.realestateapp.entity.User;

import java.util.Optional;

@Repository
@Profile("dummy")
@Primary
public class UserRepositoryDummy implements UserRepository {


    @Override
    public Optional<User> findByUsername(String username) {
        User user = new User();
        user.setUsername("test");
        user.setId(1L);
        user.setPassword("testpassword");
        return Optional.of(user);
    }
}
