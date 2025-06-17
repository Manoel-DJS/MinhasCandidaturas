package com.tec.api_candidatura.web.dto.request;

import java.util.UUID;

public record CreateCandidatureDto (UUID userId, Long jobVacancyId) {
}
