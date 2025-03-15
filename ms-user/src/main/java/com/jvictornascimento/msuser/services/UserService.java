package com.jvictornascimento.msuser.services;

import com.jvictornascimento.msuser.UserDto;
import com.jvictornascimento.msuser.models.UserModel;
import com.jvictornascimento.msuser.repositories.UserRepository;
import com.jvictornascimento.msuser.services.exceptions.EmailNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserDto findByEmail(String email) {
        if(!repository.existsByEmail(email)) {
            throw new EmailNotFound(email);
        }
        UserModel user = repository.findByEmail(email);
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
