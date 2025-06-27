package com.tec.api_candidatura.web.controller;

import com.tec.api_candidatura.documentation.AuthControllerDocs;
import com.tec.api_candidatura.entity.User;
import com.tec.api_candidatura.repository.UserRepository;
import com.tec.api_candidatura.security.AuthorizationService;
import com.tec.api_candidatura.security.TokenService;
import com.tec.api_candidatura.service.AuthenticationService;
import com.tec.api_candidatura.web.dto.request.RequestAuthenticationDto;
import com.tec.api_candidatura.web.dto.request.RegisterUserDto;
import com.tec.api_candidatura.web.dto.response.LoginResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v7/auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerDocs {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid RequestAuthenticationDto dto) {
        var token = authenticationService.login(dto.username(), dto.password());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterUserDto dto) {
        try {
            String message = authenticationService.register(dto);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json").body("{\"message\":\"" + message + "\"}");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("{\"error\":\"" + ex.getMessage() + "\"}");
        }
    }
}

