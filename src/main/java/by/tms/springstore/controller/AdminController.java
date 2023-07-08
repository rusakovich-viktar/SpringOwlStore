package by.tms.springstore.controller;

import by.tms.springstore.domain.User;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static by.tms.springstore.utils.Constants.Attributes.USERS;
import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
import static by.tms.springstore.utils.Constants.PagePath.ADMIN_ADMINPANEL;
import static by.tms.springstore.utils.Constants.PagePath.ADMIN_USERLIST;
import static by.tms.springstore.utils.Constants.PagePath.EDIT_PROFILE;
import static by.tms.springstore.utils.Constants.PagePath.REDIRECT_ADMIN_ALL;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    private final UserService userService;

    @PostMapping("/edit/{id}")
    public ModelAndView editUserProfileInfo(@PathVariable Long id,
                                            ModelAndView modelAndView) {
        UserDto userDto = userService.findUserDtoById(id);
        modelAndView.addObject(USER_DTO, userDto).setViewName(EDIT_PROFILE);
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView showUserList(ModelAndView modelAndView) {
        List<User> users = userService.findAll().stream()
                .sorted(Comparator.comparing(User::getUsername))
                .collect(Collectors.toList());
        modelAndView.addObject(USERS, users).setViewName(ADMIN_USERLIST);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView showAdminPage() {
        return new ModelAndView(ADMIN_ADMINPANEL);
    }

    @PostMapping("/active/{id}")
    public ModelAndView accountActivation(@ModelAttribute(USER_DTO) UserDto userDto) {
        userService.accountEnableStatus(userDto);
        return new ModelAndView(REDIRECT_ADMIN_ALL);
    }
}