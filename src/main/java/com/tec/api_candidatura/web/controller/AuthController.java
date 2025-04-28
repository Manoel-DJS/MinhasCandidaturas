package com.tec.api_candidatura.web.controller;

import com.tec.api_candidatura.entity.User;
import com.tec.api_candidatura.repository.UserRepository;
import com.tec.api_candidatura.security.TokenService;
import com.tec.api_candidatura.web.dto.request.RequestAuthenticationDto;
import com.tec.api_candidatura.web.dto.request.RegisterUserDto;
import com.tec.api_candidatura.web.dto.response.LoginResponseDto;
import jakarta.validation.Valid;
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

@RestController
@RequestMapping("/api/v7/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid RequestAuthenticationDto requestAuthenticationDto) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(
                requestAuthenticationDto.username(),
                requestAuthenticationDto.password()
        );

        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterUserDto registerUserDto){
        if(this.userRepository.findByName(registerUserDto.username()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerUserDto.password());

          User newUser = new User();
          newUser.setName(registerUserDto.username());
          newUser.setPassword(encryptedPassword);
          newUser.setEmail(registerUserDto.email());
          newUser.setRole(registerUserDto.role());

         // User novoRapaz = new User(registerUserDto.username(), encryptedPassword, registerUserDto.email(), registerUserDto.role()); //

        this.userRepository.save(newUser);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json").body("{\"message\":\"Usuário Criado Com Sucesso!\"}");
    }
}
