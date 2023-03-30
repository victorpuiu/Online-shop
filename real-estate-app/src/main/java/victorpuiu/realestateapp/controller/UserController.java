package victorpuiu.realestateapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.dto.UserUpdateRequest;
import victorpuiu.realestateapp.service.UserService;

@RestController
@RequestMapping()
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserUpdateRequest request) {
        request.setId(id);
        UserDto updateUser = userService.updateUser(request);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }




}
