package com.jvictornascimento.mssendemail.controllers;

import com.jvictornascimento.mssendemail.models.EmailModel;
import com.jvictornascimento.mssendemail.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {
    private final EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }
    @PostMapping
    public void sendEmail(@RequestBody EmailModel email){
        service.sendMail(email);
    }
}