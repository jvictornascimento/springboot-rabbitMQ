package com.jvictornascimento.msnewsletter.services;

import com.jvictornascimento.msnewsletter.clientFeign.ClientFeignUser;
import com.jvictornascimento.msnewsletter.models.UserModel;
import com.jvictornascimento.msnewsletter.producer.NewsLetterProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLetterService {
    private final ClientFeignUser feignClient;
    private final NewsLetterProducer producer;

    public NewsLetterService(ClientFeignUser feignClient , NewsLetterProducer producer) {
        this.feignClient = feignClient;
        this.producer = producer;
    }
    public void sendNewsLetter(){
        List<UserModel> list = feignClient.getAll().getBody();
        for( UserModel u : list){
            producer.publishMessageEmail(u);
        }
    }
}
