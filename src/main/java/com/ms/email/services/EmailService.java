package com.ms.email.services;

import com.ms.email.enumerations.Situation;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    public EmailRepository emailRepository;
    @Autowired
    public JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDate(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getBody());
            emailSender.send(message);

            emailModel.setSituation(Situation.SENT);
        } catch (MailException e) {
            emailModel.setSituation(Situation.ERROR);
        } finally {
            return emailRepository.save(emailModel);
        }
    }
}
