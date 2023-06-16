package by.tms.springstore.utils;

import by.tms.springstore.domain.User;
import by.tms.springstore.service.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static by.tms.springstore.utils.Constants.Attributes.USERNAME;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        try {
            customUserDetailsService.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return; // все ок, пользователь не найден
        }
        errors.rejectValue(USERNAME, "", "Человек с таким именем пользователя уже существует");
    }

}
