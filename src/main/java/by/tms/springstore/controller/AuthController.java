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

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserValidator userValidator;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public ModelAndView performRegistration(@ModelAttribute("user") @Valid User user,
                                            BindingResult bindingResult, ModelAndView modelAndView) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/auth/registration");
        } else {
            boolean registrationSuccess = userService.registrationNewUser(user);
            if (registrationSuccess) {
                modelAndView.addObject("successRegistration", true);
//                modelAndView.setViewName("redirect:/auth/login?success=true");
            } else {
                modelAndView.addObject("errorRegistration", true);
            }
        }
        return modelAndView;
    }
//            modelAndView.setViewName("redirect:/auth/login");
}