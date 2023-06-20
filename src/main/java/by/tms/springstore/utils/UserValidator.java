package by.tms.springstore.utils;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserFormDTO_;
import by.tms.springstore.service.UserService;
import by.tms.springstore.service.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

import static by.tms.springstore.utils.Constants.Attributes.USERNAME;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final CustomUserDetailsService customUserDetailsService;
    private final UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserFormDTO_.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserFormDTO_ user = (UserFormDTO_) o;
        checkUserLoginAndEmail(errors, user);
        checkPasswordInputVerify(errors, user);
//        try {
//            customUserDetailsService.loadUserByUsername(user.getUsername());
//        } catch (UsernameNotFoundException ignored) {
//            return; // все ок, пользователь не найден
//        }
//        errors.rejectValue(USERNAME, "", "Человек с таким именем пользователя уже существует");
    }

    private void checkUserLoginAndEmail(Errors errors, UserFormDTO_ testUser) {
        Optional<User> user = userService.getVerifyUser(testUser.getUsername(), testUser.getEmail());
        if (user.isPresent()) {
            User foundUser = user.get();
            checkUserByLogin(errors, testUser, foundUser);
            checkUserByEmail(errors, testUser, foundUser);
        }
    }

    private void checkUserByEmail(Errors errors, UserFormDTO_ testUser, User foundUser) {
        if (foundUser.getEmail().equals(testUser.getEmail())) {
            errors.rejectValue("email", "", "EXISTING_EMAIL already USED");
        }
    }

    private void checkUserByLogin(Errors errors, UserFormDTO_ testUser, User foundUser) {
        if (foundUser.getUsername().equals(testUser.getUsername())) {
            errors.rejectValue(USERNAME, "", "EXISTING_USER already Used");
        }
    }

    private void checkPasswordInputVerify(Errors errors, UserFormDTO_ user) {
        if (!user.getPassword().equals(user.getVerifyPassword())) {
            errors.rejectValue("password", "", "PASSWORDS_not_MATCHING");
        }
    }
}
