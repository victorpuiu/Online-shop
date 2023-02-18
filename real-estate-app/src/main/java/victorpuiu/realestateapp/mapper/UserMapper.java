package victorpuiu.realestateapp.mapper;

import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.entity.User;

public class UserMapper {
    public static UserDto toUserDto(User user){
        if (user == null){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());

        return userDto;
    }
}
