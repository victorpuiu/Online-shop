package victorpuiu.realestateapp.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import victorpuiu.realestateapp.dto.UserDeleteRequest;
import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.dto.UserRegistrationRequest;
import victorpuiu.realestateapp.dto.UserUpdateRequest;
import victorpuiu.realestateapp.entity.User;
import victorpuiu.realestateapp.exception.UserAlreadyExistsException;
import victorpuiu.realestateapp.mapper.UserMapper;
import victorpuiu.realestateapp.repository.UserRepository;

import java.util.Optional;


@Service
public class UserServiceDefault implements UserService{

    private final UserRepository userRepository;

    public UserServiceDefault(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto getUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + id));
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + request.getId()));
        Optional<User> existingUser = userRepository.findByUsername(request.getUserName());
        if (existingUser.isPresent() && !existingUser.get().getId().equals(user.getId())){
            throw new UserAlreadyExistsException("Username already exists: " + request.getUserName());
        }

        user.setUsername(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto createUser(UserRegistrationRequest request) {
        Optional<User> existingUser = userRepository.findByUsername(request.getUsername());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("Username already exists: " + request.getUsername());
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        return UserMapper.toUserDto(user);
    }

    @Override
    public void deleteUser(UserDeleteRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + request.getId()));

        userRepository.delete(user);


    }
}













