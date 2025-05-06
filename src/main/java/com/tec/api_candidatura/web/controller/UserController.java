package com.tec.api_candidatura.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v7/users")
public class UserController {

    @GetMapping("/ok")
    public String ReturnOK() {
        return "OK";
    }
}
