package com.tec.api_candidatura.web.dto.request;

import com.tec.api_candidatura.entity.enums.StatusCandidature;

public record UpdateCandidatureStatusDto(
        StatusCandidature status
)
{ }
