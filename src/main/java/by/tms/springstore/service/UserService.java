package by.tms.springstore.service;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;

public interface UserService  {

    User getUserByLoginAndPassword(String login, String password);

    void addNewUser(User user);

    void updateUser(UserDto userDto);

    UserDto findUserDtoById(Long id);

}
