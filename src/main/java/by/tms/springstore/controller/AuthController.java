package by.tms.springstore.controller;

import by.tms.springstore.dto.UserDtoFromRegistrationForm;
import by.tms.springstore.mapper.UserMapper;
import by.tms.springstore.service.UserService;
import by.tms.springstore.validate.UserValidatorRegistration;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.springstore.utils.Constants.Attributes.ERROR_REGISTRATION;
import static by.tms.springstore.utils.Constants.Attributes.SUCCESS_REGISTRATION;
import static by.tms.springstore.utils.Constants.Attributes.USER;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_LOGIN;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_REGISTRATION;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserValidatorRegistration userValidatorRegistration;
    private final UserMapper userMapper;

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView(AUTH_LOGIN);
    }

    @GetMapping("/registration")
    public ModelAndView registrationPage(@ModelAttribute(USER) UserDtoFromRegistrationForm user) {
        return new ModelAndView(AUTH_REGISTRATION);
    }

    @PostMapping("/registration")
    public ModelAndView performRegistration(@ModelAttribute(USER) @Valid UserDtoFromRegistrationForm user,
                                            BindingResult bindingResult, ModelAndView modelAndView) {
        userValidatorRegistration.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(AUTH_REGISTRATION);
        } else {
            boolean registrationSuccess = userService.registrationNewUser(userMapper.convertToUser(user));
            if (registrationSuccess) {
                modelAndView.addObject(SUCCESS_REGISTRATION, true);
            } else {
                modelAndView.addObject(ERROR_REGISTRATION, true);
            }
        }
        return modelAndView;
    }

    @PostMapping("/logout")
    public ModelAndView logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            SecurityContextHolder.clearContext();
        }
        return new ModelAndView("redirect:/auth/login?logout");
    }

}