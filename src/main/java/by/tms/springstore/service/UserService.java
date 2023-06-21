package by.tms.springstore.service;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;

import java.util.Optional;

public interface UserService {

    User getUserByLoginAndPassword(String login, String password);

    boolean registrationNewUser(User user);

    void updateUser(UserDto userDto);

    UserDto findUserDtoById(Long id);

    User findByUsername(String username);

    void save(User user);

    Optional<User> getVerifyUserByUsernameOrEmail(String login, String email);

    Optional<User> getVerifyUserByEmail(String email);
}
