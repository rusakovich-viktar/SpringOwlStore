package by.tms.springstore.service;

import by.tms.springstore.dto.ContactForm;

public interface EmailService {

    void send(String emailTo, String subject, String text);

    void sendContactForm(ContactForm contactForm);

    String sendPasswordReset(String userEmail);

}
