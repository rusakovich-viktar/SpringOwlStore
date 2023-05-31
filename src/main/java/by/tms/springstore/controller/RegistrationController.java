package by.tms.springstore.controller;

import by.tms.springstore.domain.User;
import by.tms.springstore.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.springstore.utils.Constants.Attributes.USER;
import static by.tms.springstore.utils.Constants.PagePath.REDIRECT_TO_HOME;
import static by.tms.springstore.utils.Constants.PagePath.SIGN_UP;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class RegistrationController {

    private final UserService userService;

    @PostMapping()
    public ModelAndView addNewUserToDataBase(@ModelAttribute("user") User user,
                                             ModelAndView modelAndView) {
        modelAndView.setViewName(REDIRECT_TO_HOME);
        userService.addNewUser(user);
        return modelAndView;
    }

    @GetMapping()
    public ModelAndView getRegistrationPage(ModelAndView modelAndView) {
        modelAndView.addObject(USER, new User());
        modelAndView.setViewName(SIGN_UP);
        return modelAndView;
    }
}
