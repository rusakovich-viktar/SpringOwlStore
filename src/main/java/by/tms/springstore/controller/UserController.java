package by.tms.springstore.controller;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.mapper.UserMapper;
import by.tms.springstore.security.CustomUserDetails;
import by.tms.springstore.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.springstore.utils.Constants.Attributes.USERNAME;
import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
import static by.tms.springstore.utils.Constants.PagePath.EDIT_PROFILE;
import static by.tms.springstore.utils.Constants.PagePath.HOME;
import static by.tms.springstore.utils.Constants.PagePath.PROFILE;
import static by.tms.springstore.utils.Constants.PagePath.REDIRECT_TO_PROFILE;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/profile/{userId}")
    public ModelAndView showUserProfile(@PathVariable("userId") Long id,
                                        ModelAndView modelAndView) {
        UserDto newUserDto = userService.findUserDtoById(id);
        modelAndView.addObject(USER_DTO, newUserDto);
        modelAndView.setViewName(PROFILE);
        return modelAndView;
    }

    @GetMapping("/edit")
    public String editUserProfileInfo(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        UserDto userDto = userMapper.convertToUserDto(user);
        model.addAttribute("userDto", userDto);
        return "edit-profile";
    }

    @PostMapping("/profile")
    public ModelAndView updateProfile(@ModelAttribute("userDto") @Valid UserDto userDto,
                                      BindingResult bindingResult,
                                      ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(PROFILE);
            return modelAndView;
        }
        userService.updateUser(userDto);
        modelAndView.setViewName(PROFILE);
        return modelAndView;
    }
}