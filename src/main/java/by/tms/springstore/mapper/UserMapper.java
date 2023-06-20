package by.tms.springstore.mapper;


import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.dto.UserFormDTO_;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//если убрать, компилятор ругается The following options were not recognized by any processor: '[mapstruct.defaultComponentModel]'
public interface UserMapper {

    UserDto convertToUserDto(User user);

    User convertToUser(UserFormDTO_ userFormDTO_);
}