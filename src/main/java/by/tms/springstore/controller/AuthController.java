package by.tms.springstore.controller;

import by.tms.springstore.domain.User;
import by.tms.springstore.service.UserService;
import by.tms.springstore.utils.UserValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.springstore.utils.Constants.Attributes.ERROR_REGISTRATION;
import static by.tms.springstore.utils.Constants.Attributes.SUCCESS_REGISTRATION;
import static by.tms.springstore.utils.Constants.Attributes.USER;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_LOGIN;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_REGISTRATION;

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserValidator userValidator;

    @GetMapping("/login")
    public String loginPage() {
        return AUTH_LOGIN;
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute(USER) User user) {
        return AUTH_REGISTRATION;
    }

    @PostMapping("/registration")
    public ModelAndView performRegistration(@ModelAttribute(USER) @Valid User user,
                                            BindingResult bindingResult, ModelAndView modelAndView) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(AUTH_REGISTRATION);
        } else {
            boolean registrationSuccess = userService.registrationNewUser(user);
            if (registrationSuccess) {
                modelAndView.addObject(SUCCESS_REGISTRATION, true);
            } else {
                modelAndView.addObject(ERROR_REGISTRATION, true);
            }
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout() {
        return AUTH_LOGIN;
    }

}