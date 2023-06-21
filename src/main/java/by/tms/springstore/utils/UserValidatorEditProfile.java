package by.tms.springstore.utils;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.dto.UserDtoFromRegistrationForm;
import by.tms.springstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserValidatorEditProfile implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDto user = (UserDto) o;
        checkUserLoginAndEmail(errors, user);
    }

    private void checkUserLoginAndEmail(Errors errors, UserDto testUser) {
        Optional<User> user = userService.getVerifyUserByEmail(testUser.getEmail());
        if (user.isPresent()) {
            User foundUser = user.get();
            checkUserByEmail(errors, testUser, foundUser);
        }
    }
//TODO Добавить проверку если пользователь не меняет почту
    private void checkUserByEmail(Errors errors, UserDto testUser, User foundUser) {
        if (foundUser.getEmail().equals(testUser.getEmail())) {
            errors.rejectValue("email", "", "Пользователь с такой электронной почтой уже существует");
        }
    }
}