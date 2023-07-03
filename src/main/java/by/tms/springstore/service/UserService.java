package by.tms.springstore.service;

import by.tms.springstore.domain.Role;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUserByLoginAndPassword(String login, String password);

    boolean registrationNewUser(User user);

    void updateUser(UserDto userDto);

    UserDto findUserDtoById(Long id);

    User findByUsername(String username);

    UserDto findUserDtoByUsername(String username);

    void save(User user);

    Optional<User> getVerifyUserByUsernameOrEmail(String login, String email);

    Optional<User> getVerifyUserByEmail(String email);

    List<User> findAll();

    void changeUserRole(Long userId, Role role);

}
