package by.tms.springstore.service.impl;

import by.tms.springstore.dto.UserDtoFromContactForm;
import by.tms.springstore.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
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

    public void send(String emailTo, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(emailTo);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    @Override
    public void sendContactForm(UserDtoFromContactForm userDtoFromContactForm) {
        CompletableFuture.runAsync(() -> {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mailMessage = new MimeMessageHelper(message);
            try {
                mailMessage.setFrom(username);
                mailMessage.setTo(SUPPORT_EMAIL);
                mailMessage.setSubject(SUPPORT_SUBJECT);
                mailMessage.setText("Email пользователя: <b>" + userDtoFromContactForm.getEmail() + "</b><br>" +
                        "Номер телефона: " + userDtoFromContactForm.getPhone() + "<br><br>" +
                        "<b>Текст сообщения: </b>" + userDtoFromContactForm.getMessage(), true);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            javaMailSender.send(message);
        });
    }

    @Override
    public String sendPasswordReset(String userEmail) {
        // Генерация нового пароля
        String newPassword = RandomString.make(8);

        // Подготовка и асинхронная отправка письма с паролем (без задержки на странице)
        CompletableFuture.runAsync(() -> {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mailMessage = new MimeMessageHelper(message);
            try {
                mailMessage.setFrom(SUPPORT_EMAIL);
                mailMessage.setTo(userEmail);
                mailMessage.setSubject("Сброс пароля");
                mailMessage.setText("<h2>Здравствуйте!</h2>" +
                        "<p>Ваш новый пароль для доступа к OWLstore: <b>" + newPassword + "</b><br><br>" +
                        "<h4>После входа в аккаунт рекомендуем изменить пароль в личном кабинете.</h4>" +
                        "Если вы считаете, что данное сообщение отправлено вам по ошибке, проигнорируйте его.</p>", true);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            javaMailSender.send(message);
        });
        return newPassword;
    }
}