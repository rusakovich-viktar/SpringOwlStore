package by.tms.springstore.controller;

import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
import static by.tms.springstore.utils.Constants.PagePath.EDIT_PROFILE;
import static by.tms.springstore.utils.Constants.PagePath.ERROR_403;
import static by.tms.springstore.utils.Constants.PagePath.PROFILE;

import by.tms.springstore.dto.UserDto;
import by.tms.springstore.repository.UserRepository;
import by.tms.springstore.service.UserService;
import by.tms.springstore.validate.UserValidatorEditProfile;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserValidatorEditProfile userValidatorEditProfile;

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/profile/{userId}")
    public ModelAndView showUserProfile(@PathVariable("userId") Long id, ModelAndView modelAndView, @AuthenticationPrincipal UserDetails userDetails) {
        String loggedInUsername = userDetails.getUsername();
        boolean isAdmin = userDetails.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
        UserDto newUserDto = userService.findUserDtoById(id);
        if (newUserDto != null && loggedInUsername.equals(newUserDto.getUsername()) || isAdmin) {
            modelAndView.addObject(USER_DTO, newUserDto);
            modelAndView.setViewName(PROFILE);
        } else {
            modelAndView.setViewName(ERROR_403);
        }
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editUserProfileInfo(Authentication authentication, ModelAndView modelAndView) {
        String username = authentication.getName();
        UserDto userDto = userService.findUserDtoByUsername(username);
        modelAndView.addObject(USER_DTO, userDto);
        modelAndView.setViewName(EDIT_PROFILE);
        return modelAndView;
    }

    @PostMapping("/profile")
    public ModelAndView updateProfile(@ModelAttribute(USER_DTO) @Valid UserDto userDto, BindingResult bindingResult, ModelAndView modelAndView) {
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
