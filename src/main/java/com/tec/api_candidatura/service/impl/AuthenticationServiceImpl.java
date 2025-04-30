package com.tec.api_candidatura.service.impl;

import com.tec.api_candidatura.repository.UserRepository;
import com.tec.api_candidatura.service.AuthenticationService;
import com.tec.api_candidatura.web.dto.request.RegisterUserDto;
import com.tec.api_candidatura.web.dto.response.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    @Override
    public LoginResponseDto register(RegisterUserDto userDto) {
        return null;
    }
}
