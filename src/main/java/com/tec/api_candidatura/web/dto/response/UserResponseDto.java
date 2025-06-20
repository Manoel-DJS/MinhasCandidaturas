package com.tec.api_candidatura.web.dto.response;

import com.tec.api_candidatura.entity.enums.UserRole;

public record UserResponseDto(
        String username,
        String email,
        UserRole role
) {
}
