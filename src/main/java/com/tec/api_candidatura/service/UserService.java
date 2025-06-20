package com.tec.api_candidatura.service;

import com.tec.api_candidatura.web.dto.request.UpdateUserDto;
import com.tec.api_candidatura.web.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto updateUser(Long id, UpdateUserDto dto);
    List<UserResponseDto> getAllUsers();
}
