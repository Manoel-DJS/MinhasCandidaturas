package com.tec.api_candidatura.web.dto.response;

import com.tec.api_candidatura.entity.enums.StatusCandidature;

public record CandidatureResponseDto(Long id, String userName, String jobTitle, StatusCandidature status) {
}
