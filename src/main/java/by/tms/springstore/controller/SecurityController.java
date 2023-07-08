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

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Controller
@RequiredArgsConstructor
public class SecurityController {

    private final EmailService emailService;
    private final UserService userService;

    @GetMapping("/forgot-password")
    public ModelAndView showResetPasswordForm() {
        return new ModelAndView("/auth/forgot-password");
    }

    @PostMapping("/reset-password")
    public ModelAndView resetPassword(@RequestParam("email") String userEmail, ModelAndView modelAndView) {
        String newPassword = emailService.sendPasswordReset(userEmail);
        userService.updatePassword(userEmail, newPassword);
        modelAndView.setViewName("/auth/reset-password");
        return modelAndView;
    }

    @GetMapping("/change-password")
    public ModelAndView showChangePasswordForm() {
        return new ModelAndView("/auth/change-password");
    }

    @PostMapping("/change-password")
    public ModelAndView changePassword(@ModelAttribute("passwordForm") @Valid UserDtoFromChangePasswordForm userDtoFromChangePasswordForm, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        String username = getContext().getAuthentication().getName();
        if (result.hasErrors()) {
            modelAndView.setViewName("/auth/change-password");
        } else {
            userService.changePassword(username, userDtoFromChangePasswordForm.getOldPassword(), userDtoFromChangePasswordForm.getNewPassword());
            modelAndView.setViewName("/auth/after-change-password");
        }
        return modelAndView;
    }


}
