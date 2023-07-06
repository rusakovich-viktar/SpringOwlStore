package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Role;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.exceptions.NotFoundException;
import by.tms.springstore.mapper.UserMapper;
import by.tms.springstore.repository.UserRepository;
import by.tms.springstore.service.EmailService;
import by.tms.springstore.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final EmailService emailService;

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        return userRepository.findByUsernameAndPassword(login, password);
    }

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
            emailService.sendEmail(user.getEmail(), "Activation code", message);
        }
        return true;
    }

    @Override
    @Transactional
    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new NotFoundException("User not found"));
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
                .orElseThrow(() -> new NotFoundException("User not found"));
        boolean active = userDto.isActive();
        user.setActive(active);
        userDto.setActive(user.isActive());
        userRepository.saveAndFlush(user);
    }

}
