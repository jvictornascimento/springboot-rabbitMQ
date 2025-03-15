package com.jvictornascimento.mssendemail.services;

import com.jvictornascimento.mssendemail.clientFeign.ClientFeignUser;
import com.jvictornascimento.mssendemail.enums.StatusEmail;
import com.jvictornascimento.mssendemail.models.EmailModel;
import com.jvictornascimento.mssendemail.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class EmailService {
private final JavaMailSender mailSender;
private final EmailRepository repository;
private final  ClientFeignUser clientFeignUser;

@Value(value = "${spring.mail.username}")
private String email;

public EmailService(JavaMailSender mailSender, EmailRepository repository,ClientFeignUser clientFeignUser){
    this.mailSender = mailSender;
    this.repository = repository;
    this.clientFeignUser = clientFeignUser;
}

public EmailModel sendMail(EmailModel emailModel) {
    var user = clientFeignUser.getUserByEmail(emailModel.getEmailTo()).getBody();
    try {
        emailModel.setSendDateEmail(LocalDateTime.now());
        emailModel.setEmailfrom(email);
        emailModel.setIdUser(user.getId());

        var message = new SimpleMailMessage();
        message.setFrom(emailModel.getEmailfrom());
        message.setTo(emailModel.getEmailTo());
        message.setSubject(emailModel.getSubject());
        message.setText(emailModel.getText());
        mailSender.send(message);

        emailModel.setStatusEmail(StatusEmail.SEND);
    } catch (MailException e){
        emailModel.setStatusEmail(StatusEmail.ERROR);
    }finally{
        return repository.save(emailModel);
    }
}
}