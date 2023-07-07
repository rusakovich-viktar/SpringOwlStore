package by.tms.springstore.controller;

import by.tms.springstore.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/send-test-email")
    public String sendTestEmail1() {

        emailService.send("testowllogin@yandex.ru","Тестовое письмо","Привет, это тестовое письмо.");
        return "Test email sent";
    }
}