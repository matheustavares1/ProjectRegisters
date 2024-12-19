package com.example.RegisterResponsible.email;

import com.example.RegisterResponsible.exceptions.EmailException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Setter
@Getter
@Service
public class SendingEmail {

    private JavaMailSender mailSender;

    @Autowired
    public SendingEmail(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
    } catch (EmailException emailException) {
            emailException.getLocalizedMessage();
        }
    }
}
