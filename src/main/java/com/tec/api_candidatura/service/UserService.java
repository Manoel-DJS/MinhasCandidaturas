package com.tec.api_candidatura.service;

import com.tec.api_candidatura.web.dto.request.UpdateUserDto;
import com.tec.api_candidatura.web.dto.response.UserResponseDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDto updateUser(UUID id, UpdateUserDto dto);
    List<UserResponseDto> getAllUsers();
}
