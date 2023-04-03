package victorpuiu.realestateapp.mapper;

import org.mapstruct.Mapper;
import victorpuiu.realestateapp.dto.UserDto;
import victorpuiu.realestateapp.entity.User;

@Mapper
public interface UserMapper {
    static UserDto toUserDto(User user){
        if (user == null){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());

        return userDto;
    }
}
