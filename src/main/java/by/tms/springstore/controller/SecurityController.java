package by.tms.springstore.controller;

import by.tms.springstore.dto.UserDtoFromChangePasswordForm;
import by.tms.springstore.service.EmailService;
import by.tms.springstore.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.springstore.utils.Constants.Attributes.PASSWORD_FORM;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_CHANGE_PASSWORD;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_CHANGE_PASSWORD_SUCCESS;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_RESET_PASSWORD;
import static by.tms.springstore.utils.Constants.RequestParams.EMAIL;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Controller
@RequiredArgsConstructor
public class SecurityController {

    private final EmailService emailService;
    private final UserService userService;


    @PostMapping("/reset-password")
    public ModelAndView resetPassword(@RequestParam(EMAIL) String userEmail, ModelAndView modelAndView) {
        String newPassword = emailService.sendPasswordReset(userEmail);
        userService.updatePassword(userEmail, newPassword);
        modelAndView.setViewName(AUTH_RESET_PASSWORD);
        return modelAndView;
    }

    @GetMapping("/change-password")
    public ModelAndView showChangePasswordForm() {
        return new ModelAndView(AUTH_CHANGE_PASSWORD);
    }

    @PostMapping("/change-password")
    public ModelAndView changePassword(@ModelAttribute(PASSWORD_FORM) @Valid UserDtoFromChangePasswordForm userDtoFromChangePasswordForm, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        String username = getContext().getAuthentication().getName();
        if (result.hasErrors()) {
            modelAndView.setViewName(AUTH_CHANGE_PASSWORD);
        } else {
            userService.changePassword(username, userDtoFromChangePasswordForm.getOldPassword(), userDtoFromChangePasswordForm.getNewPassword());
            modelAndView.setViewName(AUTH_CHANGE_PASSWORD_SUCCESS);
        }
        return modelAndView;
    }


}
