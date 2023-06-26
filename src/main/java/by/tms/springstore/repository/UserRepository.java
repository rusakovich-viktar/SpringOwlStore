package by.tms.springstore.repository;

import by.tms.springstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User saveAndFlush(User user);

    User findByUsernameAndPassword(String login, String password);

    Optional<User> findById(Long id);

    User findByUsername(String username);

    Optional<User> findFirstByUsername(String username);

    Optional<User> findUserByUsernameOrEmail(String login, String email);

    Optional<User> findUserByEmail(String email);
}