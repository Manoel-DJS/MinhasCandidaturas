package com.tec.api_candidatura.service.impl;

import com.tec.api_candidatura.entity.User;
import com.tec.api_candidatura.repository.UserRepository;
import com.tec.api_candidatura.security.TokenService;
import com.tec.api_candidatura.service.AuthenticationService;
import com.tec.api_candidatura.web.dto.request.RegisterUserDto;
import com.tec.api_candidatura.web.exception.customException.InvalidCredentialsException;
import com.tec.api_candidatura.web.exception.customException.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    public String login(String username, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            return tokenService.generateToken((User) auth.getPrincipal());

        } catch (BadCredentialsException ex) {
            throw new InvalidCredentialsException("Usuário ou senha inválidos", ex);
        }
    }

    @Override
    public String register(RegisterUserDto dto) {
        if (userRepository.findByName(dto.username()) != null) {
            throw new UserAlreadyExistsException("Usuário já existe.");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        User user = new User();
        user.setName(dto.username());
        user.setEmail(dto.email());
        user.setPassword(encryptedPassword);
        user.setRole(dto.role());

        userRepository.save(user);
        return "Usuário Criado Com Sucesso!";
    }

}
