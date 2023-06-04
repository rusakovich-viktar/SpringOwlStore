package by.tms.springstore.repository;

import by.tms.springstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User saveAndFlush(User user);
    //    void addNewUser(User user);

    User findByUsernameAndPassword(String login, String password);

    //    User getUserByLoginAndPassword(String login, String password);
//    UserDto updateUserDtoById(UserDto user);
    Optional<User> findById(Long id);
    //    UserDto findUserDtoById(Long id);

    User findFirstByName(String name);
}