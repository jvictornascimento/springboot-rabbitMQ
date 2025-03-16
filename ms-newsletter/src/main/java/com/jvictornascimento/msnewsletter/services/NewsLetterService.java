package com.jvictornascimento.msnewsletter.services;

import com.jvictornascimento.msnewsletter.clientFeign.ClientFeignUser;
import com.jvictornascimento.msnewsletter.models.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLetterService {
    private final ClientFeignUser feignClient;

    public NewsLetterService(ClientFeignUser feignClient) {
        this.feignClient = feignClient;
    }
    public void sendNewsLetter(){
        List<UserModel> list = feignClient.getAll().getBody();
        list.forEach(System.out::println);
    }

}
