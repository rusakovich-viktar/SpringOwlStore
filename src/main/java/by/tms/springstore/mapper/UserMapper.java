package by.tms.springstore.mapper;


import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") //если убрать, компилятор ругается The following options were not recognized by any processor: '[mapstruct.defaultComponentModel]'
public interface UserMapper {

    UserDto convertToUserDto(User user);
}
