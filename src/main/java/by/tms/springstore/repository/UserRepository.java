package by.tms.springstore.repository;

import by.tms.springstore.dto.UserDto;
import by.tms.springstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    void addNewUser(User user);

    User saveAndFlush(User user);

    User findByUsernameAndPassword(String login, String password);
//    User getUserByLoginAndPassword(String login, String password);

//    UserDto updateUserDtoById(UserDto user);
//
//    UserDto findUserDtoById(Long id);

    Optional<User> findById(Long id);
}