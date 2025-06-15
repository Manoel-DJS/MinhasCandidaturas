package com.tec.api_candidatura.web.dto.response;

import com.tec.api_candidatura.entity.enums.JobVacancyStatus;
import com.tec.api_candidatura.entity.enums.JobVacancyType;

public record JobVacancyResponseDto(
        Long id,
        String title,
        String description,
        String jobCompany,
        String location,
        JobVacancyType type,
        JobVacancyStatus status
) {}

