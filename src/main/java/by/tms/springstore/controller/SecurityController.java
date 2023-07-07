package by.tms.springstore.controller;

import by.tms.springstore.service.EmailService;
import by.tms.springstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SecurityController {

    private final EmailService emailService;
    private final UserService userService;

    @GetMapping("/forgot-password")
    public String showResetPasswordForm() {
        return "/auth/forgot-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("email") String userEmail) {
        String newPassword = emailService.sendPasswordReset(userEmail);
        userService.updatePassword(userEmail, newPassword);
        return "/auth/reset-password";
    }


}
