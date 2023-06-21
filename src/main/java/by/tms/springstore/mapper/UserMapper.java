package by.tms.springstore.mapper;


import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.dto.UserDtoFromRegistrationForm;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//если убрать, компилятор ругается что не знает что это компонент спринга - (оставляю).
// The following options were not recognized by any processor: '[mapstruct.defaultComponentModel]'
public interface UserMapper {

    UserDto convertToUserDto(User user);

    User convertToUser(UserDtoFromRegistrationForm userDtoFromRegistrationForm);
}