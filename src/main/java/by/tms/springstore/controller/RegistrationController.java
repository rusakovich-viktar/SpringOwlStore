package by.tms.springstore.controller;

import by.tms.springstore.domain.User;
import by.tms.springstore.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.tms.springstore.utils.Constants.RequestParams.BIRTHDAY;
import static by.tms.springstore.utils.Constants.RequestParams.EMAIL;
import static by.tms.springstore.utils.Constants.RequestParams.GENDER;
import static by.tms.springstore.utils.Constants.RequestParams.NAME;
import static by.tms.springstore.utils.Constants.RequestParams.PASSWORD;
import static by.tms.springstore.utils.Constants.RequestParams.REGISTRATION_DATE;
import static by.tms.springstore.utils.Constants.RequestParams.REPEAT_PASS;
import static by.tms.springstore.utils.Constants.RequestParams.SURNAME;
import static by.tms.springstore.utils.Constants.RequestParams.USERNAME;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class RegistrationController {

    private final UserService userService;

    @PostMapping()
    public ModelAndView addUser(@ModelAttribute User user,
                                @RequestParam(USERNAME) String username,
                                @RequestParam(PASSWORD) String password,
                                @RequestParam(REPEAT_PASS) String repeatPass,
                                @RequestParam(NAME) String name,
                                @RequestParam(SURNAME) String surname,
                                @RequestParam(BIRTHDAY) String birthday,
                                @RequestParam(GENDER) String gender,
                                @RequestParam(EMAIL) String email,
                                @RequestParam(REGISTRATION_DATE) LocalDate registrationDate,
                                ModelAndView modelAndView,
                                Model model
    ) {
        try {
            if (username == null || password == null || repeatPass == null || name == null || surname == null || birthday == null || gender == null || username.isEmpty() || password.isEmpty() || repeatPass.isEmpty() || name.isEmpty() || surname.isEmpty() || birthday.isEmpty() || gender.isEmpty()) {
                model.addAttribute("error", "Необходимо заполнить все поля формы.");
            } else if (password.length() < 8) {
                model.addAttribute("error", "Password must have minimum 8 characters.");
            } else {
                if (!password.equals(repeatPass)) {
                    model.addAttribute("error", "Passwords don't match.");
                    modelAndView.setViewName("signup");
                }

                Pattern pattern = Pattern.compile(".+@.+\\..+");
                Matcher matcher = pattern.matcher(email);

                if (!matcher.matches()) {
                    model.addAttribute("error", "Некорректный формат email.");
                } else {
                    userService.addNewUser(new User(username, name, surname, gender, birthday, email, /*registrationDate,*/ password));
//                    userService.addNewUser(new User(username, name, surname, gender, birthday, email, registrationDate, password));
                    modelAndView.setViewName("redirect:/signin");
                }
            }
        } catch (Exception e) {
            log.error("Exception ", e);
            model.addAttribute("error", "Произошла ошибка при регистрации.");
        }
        return modelAndView;
    }

    @GetMapping()
    public String getRegistrationPage() {
        return "signup";
    }
}
