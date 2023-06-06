package by.tms.springstore.controller;

import by.tms.springstore.dto.UserDto;
import by.tms.springstore.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.springstore.utils.Constants.Attributes.USERNAME;
import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
import static by.tms.springstore.utils.Constants.PagePath.EDIT_PROFILE;
import static by.tms.springstore.utils.Constants.PagePath.PROFILE;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @GetMapping("/profile")
    public ModelAndView showUserProfile(@RequestParam("id") Long id,
                                        ModelAndView modelAndView) {
        UserDto newUserDto = userService.findUserDtoById(id);
        modelAndView.addObject(USER_DTO, newUserDto);
        modelAndView.setViewName(PROFILE);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView editUserProfileInfo(HttpSession session, ModelAndView modelAndView) {
        UserDto userDto = (UserDto) session.getAttribute(USER_DTO);
        modelAndView.setViewName(EDIT_PROFILE);
        modelAndView.addObject(USER_DTO, userDto);
        return modelAndView;
    }

    @PostMapping("/profile")
    public ModelAndView updateProfile(@ModelAttribute("userDto") @Valid UserDto userDto,
                                      BindingResult bindingResult,
                                      ModelAndView modelAndView, HttpSession session) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(PROFILE);
            return modelAndView;
        }
        userService.updateUser(userDto);
        modelAndView.setViewName(PROFILE);
        session.setAttribute(USERNAME, userDto.getUsername());
        session.setAttribute(USER_DTO, userDto);
        return modelAndView;
    }
}