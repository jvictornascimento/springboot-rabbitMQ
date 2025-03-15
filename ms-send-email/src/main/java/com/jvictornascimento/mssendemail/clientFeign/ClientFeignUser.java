package com.jvictornascimento.mssendemail.clientFeign;

import com.jvictornascimento.mssendemail.models.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "ms-user",url = "http://localhost:8001/users")
public interface ClientFeignUser {
    @GetMapping
    ResponseEntity<UserModel> getUserByEmail(@RequestParam String email);
}
