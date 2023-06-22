package by.tms.springstore.controller;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.mapper.UserMapper;
import by.tms.springstore.service.UserService;
import by.tms.springstore.utils.UserValidatorEditProfile;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
import static by.tms.springstore.utils.Constants.PagePath.EDIT_PROFILE;
import static by.tms.springstore.utils.Constants.PagePath.PROFILE;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserValidatorEditProfile userValidatorEditProfile;

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
    public ModelAndView editUserProfileInfo(Authentication authentication, ModelAndView modelAndView) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        UserDto userDto = userMapper.convertToUserDto(user);
        modelAndView.addObject(USER_DTO, userDto);
        modelAndView.setViewName(EDIT_PROFILE);
        return modelAndView;
    }

    @PostMapping("/profile")
    public ModelAndView updateProfile(@ModelAttribute(USER_DTO) @Valid UserDto userDto,
                                      BindingResult bindingResult,
                                      ModelAndView modelAndView) {
        userValidatorEditProfile.validate(userDto, bindingResult);
        if (!bindingResult.hasErrors()) {
            userService.updateUser(userDto);
            modelAndView.setViewName(PROFILE);
        } else {
            modelAndView.setViewName(EDIT_PROFILE);
        }
        return modelAndView;

    }
}