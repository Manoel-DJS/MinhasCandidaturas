package com.tec.api_candidatura.web.dto.request;

import com.tec.api_candidatura.entity.enums.JobVacancyStatus;

public record UpdateJobVacancyDto(String description, JobVacancyStatus status) {
}
