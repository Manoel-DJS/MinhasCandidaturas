package com.tec.api_candidatura.web.controller;

import com.tec.api_candidatura.entity.User;
import com.tec.api_candidatura.service.UserService;
import com.tec.api_candidatura.web.dto.request.UpdateUserDto;
import com.tec.api_candidatura.web.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v7/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable UUID id, @RequestBody UpdateUserDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<UserResponseDto>> list() {
        return ResponseEntity.ok(userService.getAllUsers());
    }




}
