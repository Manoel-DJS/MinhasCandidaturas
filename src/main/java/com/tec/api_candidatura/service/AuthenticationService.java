package com.tec.api_candidatura.service;

import com.tec.api_candidatura.web.dto.request.RegisterUserDto;
import com.tec.api_candidatura.web.dto.response.LoginResponseDto;

public interface AuthenticationService {
    LoginResponseDto register(RegisterUserDto userDto);
}
