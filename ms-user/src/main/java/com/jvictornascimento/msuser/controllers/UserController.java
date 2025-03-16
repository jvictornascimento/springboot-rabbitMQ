package com.jvictornascimento.msuser.controllers;

import com.jvictornascimento.msuser.UserDto;
import com.jvictornascimento.msuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam String email){
        return ResponseEntity.ok(service.findByEmail(email));
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
