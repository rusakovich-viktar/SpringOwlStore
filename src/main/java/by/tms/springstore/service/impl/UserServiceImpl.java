package by.tms.springstore.service.impl;

import static by.tms.springstore.utils.Constants.Attributes.NOT_FOUND;
import static by.tms.springstore.utils.Constants.Attributes.USER_NOT_FOUND;

import by.tms.springstore.domain.Role;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.exceptions.InvalidUserPasswordException;
import by.tms.springstore.exceptions.UserNotFoundByEmailException;
import by.tms.springstore.exceptions.UserNotFoundException;
import by.tms.springstore.mapper.UserMapper;
import by.tms.springstore.repository.UserRepository;
import by.tms.springstore.service.EmailService;
import by.tms.springstore.service.UserService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final EmailService emailService;

    private final CustomUserDetailsService customUserDetailsService;

    @Override
    @Transactional
    public boolean registrationNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        user.setActive(false);
        user.setActivationCode(UUID.randomUUID().toString());

        userRepository.save(user);

        if (StringUtils.hasText(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to owlSTORE. Please visit the following link to activate your account: http://localhost:8080/auth/activate/%s",
                    user.getUsername(), user.getActivationCode()
            );
            emailService.send(user.getEmail(), "Activation code", message);
        }
        return true;
    }

    @Override
    @Transactional
    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        if (userDto.getRole() != null) {
            user.setRole(userDto.getRole());
        }
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserDto findUserDtoById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? modelMapper.map(user.get(), UserDto.class) : null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDto findUserDtoByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return userMapper.convertToUserDto(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getVerifyUserByUsernameOrEmail(String login, String email) {
        return userRepository.findUserByUsernameOrEmail(login, email);
    }

    @Override
    public Optional<User> getVerifyUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user != null) {

            user.setActivationCode(null);
            user.setActive(true);
            userRepository.save(user);
        } else {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void accountEnableStatus(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        boolean active = userDto.isActive();
        user.setActive(active);
        userDto.setActive(user.isActive());
        userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public void updatePassword(String email, String newPassword) {
        User user = findBy(email, "User with email " + email + NOT_FOUND);
        user.setPassword(passwordEncoder.encode(newPassword));
    }

    @Override
    @Transactional
    public void changePassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findByUsername(username);
        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
        } else {
            throw new InvalidUserPasswordException("Введенный старый пароль некорректен");
        }
    }

    private <SC> User findBy(SC searchCriteria, String errorMessage) {
        if (searchCriteria instanceof String) {
            return userRepository.findUserByEmail((String) searchCriteria)
                    .orElseThrow(() -> new UserNotFoundByEmailException(errorMessage));
        }
        if (searchCriteria instanceof Long) {
            return userRepository.findById((Long) searchCriteria)
                    .orElseThrow(() -> new UserNotFoundException(errorMessage));
        }
        throw new IllegalArgumentException("Неподдерживаемый тип репозитория: " + userRepository.getClass());
    }

}
