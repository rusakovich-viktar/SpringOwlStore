package by.tms.springstore.mapper;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.dto.UserDtoFromRegistrationForm;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserDto convertToUserDto(User user);

    User convertToUser(UserDtoFromRegistrationForm userDtoFromRegistrationForm);

    User convertUserDtoToUser(UserDto UserDto);
}
