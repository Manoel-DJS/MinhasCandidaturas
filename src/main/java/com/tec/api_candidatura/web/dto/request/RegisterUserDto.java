package com.tec.api_candidatura.web.dto.request;

import com.tec.api_candidatura.entity.User;
import com.tec.api_candidatura.entity.enums.UserRole;

public record RegisterUserDto(String username, String password, String email, UserRole role) {
}
