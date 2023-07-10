package by.tms.springstore.repository;

import by.tms.springstore.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    User saveAndFlush(User user);

    Optional<User> findById(Long id);

    User findByUsername(String username);

    Optional<User> findFirstByUsername(String username);

    Optional<User> findUserByUsernameOrEmail(String login, String email);

    Optional<User> findUserByEmail(String email);

    User findByActivationCode(String code);

}