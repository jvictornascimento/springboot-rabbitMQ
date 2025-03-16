package com.jvictornascimento.msnewsletter.producer;

import com.jvictornascimento.msnewsletter.dtos.EmailRecordDto;
import com.jvictornascimento.msnewsletter.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NewsLetterProducer {
    final RabbitTemplate rabbitTemplate;

    public NewsLetterProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        var emailDto = new EmailRecordDto();
        emailDto.setUserId(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Novidades da semana!");
        emailDto.setText(userModel.getName() + " agradeçemos o seu tempo conosco! \nTe esperamos semana que vem novamente.");

        rabbitTemplate.convertAndSend("",routingKey,emailDto);

    }
}