package by.tms.springstore.mapper;


import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto convertToUserDto(User user);
}
