package by.tms.springstore.service.impl;

import by.tms.springstore.dto.ContactForm;
import by.tms.springstore.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    private static final String SUPPORT_SUBJECT = "Сообщение от пользователя";
    private static final String SUPPORT_EMAIL = "testowllogin@yandex.ru";

    @Value("${spring.mail.username}")
    private String username;

    public void sendEmail(String emailTo, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(emailTo);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    @Override
    public void sendContactForm(ContactForm contactForm) {
        CompletableFuture.runAsync(() -> {
            MimeMessage mailSenderMimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailSenderMimeMessage);
            try {
                mimeMessageHelper.setFrom(username);
                mimeMessageHelper.setTo(SUPPORT_EMAIL);
                mimeMessageHelper.setSubject(SUPPORT_SUBJECT);
                mimeMessageHelper.setText("Email пользователя: <b>" + contactForm.getEmail() + "</b><br>" +
                        "Номер телефона: " + contactForm.getPhone() + "<br><br>" +
                        "<b>Текст сообщения: </b>" + contactForm.getMessage(), true);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            javaMailSender.send(mailSenderMimeMessage);
        });
    }
}