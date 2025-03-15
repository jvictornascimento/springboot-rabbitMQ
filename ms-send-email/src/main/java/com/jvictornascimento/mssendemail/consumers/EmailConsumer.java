package com.jvictornascimento.mssendemail.consumers;

import com.jvictornascimento.mssendemail.dtos.EmailRecordDto;
import com.jvictornascimento.mssendemail.models.EmailModel;
import com.jvictornascimento.mssendemail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }


    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDto,emailModel);
        emailService.sendMail(emailModel);

    }
}