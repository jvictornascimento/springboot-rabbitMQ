package com.jvictornascimento.msnewsletter.controllers;

import com.jvictornascimento.msnewsletter.services.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("newsletter")
public class NewsLetterController {
    @Autowired
    private NewsLetterService service;

    @PostMapping
    public ResponseEntity<Void> sendEmails(){
        service.sendNewsLetter();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
