package by.tms.springstore.service;

public interface EmailService {

    void sendEmail(String emailTo, String subject, String text);
}
