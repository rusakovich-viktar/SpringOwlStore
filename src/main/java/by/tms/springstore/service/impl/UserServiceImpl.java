package by.tms.springstore.service.impl;

import by.tms.springstore.dto.UserDto;
import by.tms.springstore.model.User;
import by.tms.springstore.repository.UserRepository;
import by.tms.springstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
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



//    @Override
//    public void updateUser(UserDto userDto) {
//        User user = convertToUser(userDto);
//        userRepository.saveAndFlush(user);
////        userRepository.updateUserDtoById(userDto);
//    }

//    private User convertToUser(UserDto userDto) {
//        return User.builder().id(userDto.getId()).
//
//        .build();



    @Override
    public UserDto findUserDtoById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? modelMapper.map(user.get(), UserDto.class) : null;
//        return user.map(value -> modelMapper.map(value, UserDto.class)).orElse(null);
//        return userRepository.findUserDtoById(id);
    }

}
