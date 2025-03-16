package com.jvictornascimento.msnewsletter.clientFeign;


import com.jvictornascimento.msnewsletter.models.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "ms-user",url = "http://localhost:8001/users")
public interface ClientFeignUser {
    @GetMapping
    ResponseEntity<UserModel> getUserByEmail(@RequestParam String email);
    @GetMapping(value = "/list")
    ResponseEntity<List<UserModel>> getAll();
}
