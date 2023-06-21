package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Role;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.exceptions.NotFoundException;
import by.tms.springstore.repository.UserRepository;
import by.tms.springstore.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        return userRepository.findByUsernameAndPassword(login, password);
//        return userRepository.getUserByLoginAndPassword(login, password);
    }

    @Override
    @Transactional
    public boolean registrationNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
        return true;
    }

    @Override
    @Transactional
    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new NotFoundException("User not found"));
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
//        user.setBirthday(userDto.getBirthday() == null ? null : LocalDate.parse(userDto.getBirthday().format(DateTimeFormatter.ISO_DATE), DateTimeFormatter.ISO_DATE));
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        userRepository.saveAndFlush(user);
    }

    @Override
    public UserDto findUserDtoById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? modelMapper.map(user.get(), UserDto.class) : null;
//        return user.map(value -> modelMapper.map(value, UserDto.class)).orElse(null);
//        return userRepository.findUserDtoById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getVerifyUser(String login, String email) {
        return userRepository.findUserByUsernameOrEmail(login, email);
    }


}
