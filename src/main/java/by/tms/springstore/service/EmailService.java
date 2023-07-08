package by.tms.springstore.service;

import by.tms.springstore.dto.UserDtoFromContactForm;

public interface EmailService {

    void send(String emailTo, String subject, String text);

    void sendContactForm(UserDtoFromContactForm userDtoFromContactForm);

    String sendPasswordReset(String userEmail);

}
