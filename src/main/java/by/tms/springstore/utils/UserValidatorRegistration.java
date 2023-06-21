package by.tms.springstore.utils;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDtoFromRegistrationForm;
import by.tms.springstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import static by.tms.springstore.utils.Constants.Attributes.USERNAME;

@Component
@RequiredArgsConstructor
public class UserValidatorRegistration implements Validator {
    private final UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDtoFromRegistrationForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDtoFromRegistrationForm user = (UserDtoFromRegistrationForm) o;
        checkUserLoginAndEmail(errors, user);
        checkPasswordInputVerify(errors, user);
        checkUserByAgeMoreEighteen(errors, user);
    }

    private void checkUserLoginAndEmail(Errors errors, UserDtoFromRegistrationForm testUser) {
        Optional<User> user = userService.getVerifyUserByUsernameOrEmail(testUser.getUsername(), testUser.getEmail());
        if (user.isPresent()) {
            User foundUser = user.get();
            checkUserByLogin(errors, testUser, foundUser);
            checkUserByEmail(errors, testUser, foundUser);

        }
    }

    private void checkUserByEmail(Errors errors, UserDtoFromRegistrationForm testUser, User foundUser) {
        if (foundUser.getEmail().equals(testUser.getEmail())) {
            errors.rejectValue("email", "", "Пользователь с такой электронной почтой уже существует");
        }
    }

    private void checkUserByLogin(Errors errors, UserDtoFromRegistrationForm testUser, User foundUser) {
        if (foundUser.getUsername().equals(testUser.getUsername())) {
            errors.rejectValue(USERNAME, "", "Пользователь с таким именем уже существует");
        }
    }

    private void checkUserByAgeMoreEighteen(Errors errors, UserDtoFromRegistrationForm user) {
        LocalDate birthday = (user.getBirthday());
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthday, currentDate);
        if (period.getYears() < 18) {
            errors.rejectValue("birthday", "", "Вы должны быть старше 18 лет");
        }
    }


    private void checkPasswordInputVerify(Errors errors, UserDtoFromRegistrationForm user) {
        if (!user.getPassword().equals(user.getVerifyPassword())) {
            errors.rejectValue("password", "", "Пароли не совпадают");
        }
    }


}
