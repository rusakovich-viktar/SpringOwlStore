package by.tms.springstore.service.impl;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.exceptions.NotFoundException;
import by.tms.springstore.repository.UserRepository;
import by.tms.springstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        return userRepository.findByUsernameAndPassword(login, password);
//        return userRepository.getUserByLoginAndPassword(login, password);
    }

    @Override
    public void addNewUser(User user) {
        userRepository.saveAndFlush(user);
//        userRepository.addNewUser(user);
    }

    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.saveAndFlush(
                user.toBuilder()
                        .name(userDto.getName())
                        .surname(userDto.getSurname())
                        .birthday(userDto.getBirthday())
                        .gender(userDto.getGender())
                        .email(userDto.getEmail())
                        .build()
        );
    }

    @Override
    public UserDto findUserDtoById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? modelMapper.map(user.get(), UserDto.class) : null;
//        return user.map(value -> modelMapper.map(value, UserDto.class)).orElse(null);
//        return userRepository.findUserDtoById(id);
    }

//    @Override
//    public boolean save(UserDto userDto) {
//        if (!Objects.equals(userDto.getPassword(), userDto.getMatchingPassword())) {
//            throw new RuntimeException("Password is not equals");
//        }
//        User user = User.builder()
//                .name(userDto.getUsername())
//                .password((passwordEncoder.encode(userDto.getPassword())))
//                .email(userDto.getEmail())
//                .role(Role.CLIENT)
//                .build();
//        userRepository.saveAndFlush(user);
//        return true;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findFirstByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with name: " + username);
//        }
//        List<GrantedAuthority> roles = new ArrayList<>();
//        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
//        return new org.springframework.security.core.userdetails.User(
//                user.getName(),
//                user.getPassword(),
//                roles
//        );
//    }
}
