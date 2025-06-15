package com.tec.api_candidatura.service;

import com.tec.api_candidatura.web.dto.request.RegisterUserDto;

public interface AuthenticationService {
    String login(String username, String password);
    String register(RegisterUserDto dto);
}
