package by.tms.springstore.controller;

import by.tms.springstore.domain.Role;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.service.UserService;
import by.tms.springstore.validate.UserValidatorEditProfile;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
import static by.tms.springstore.utils.Constants.PagePath.EDIT_PROFILE;
import static by.tms.springstore.utils.Constants.PagePath.PROFILE;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    private final UserService userService;

    @PostMapping("/edit/{id}")
    public ModelAndView editUserProfileInfo(@PathVariable("id") Long id,
                                            ModelAndView modelAndView) {
        UserDto userDto = userService.findUserDtoById(id);
        modelAndView.addObject(USER_DTO, userDto);
        modelAndView.setViewName(EDIT_PROFILE);
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return new ModelAndView("/admin/userlist");
    }

    @GetMapping
    public ModelAndView adminPage() {
        return new ModelAndView("/admin/admin-panel");
    }

}