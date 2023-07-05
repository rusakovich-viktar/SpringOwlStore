package by.tms.springstore.controller;

import by.tms.springstore.service.impl.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/send-test-email")
    public String sendTestEmail1() {

        emailService.sendEmail("yolame1068@edulena.com","Тестовое письмо","Привет, это тестовое письмо.");
        return "Test email sent";
    }
}