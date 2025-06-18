package com.tec.api_candidatura.web.controller;

import com.tec.api_candidatura.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/api/v7/users")
public class UserController {

    @GetMapping("/ok")
    public String ReturnOK() {
        return "OK";
    }

    @GetMapping
    public String getCurrentUserId(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        UUID userId = user.getId(); // ou getUuid(), dependendo do nome do campo
        return "User UUID: " + userId;
    }


}
