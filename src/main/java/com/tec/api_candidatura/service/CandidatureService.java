package com.tec.api_candidatura.service;

import com.tec.api_candidatura.entity.enums.StatusCandidature;
import com.tec.api_candidatura.web.dto.request.CreateCandidatureDto;
import com.tec.api_candidatura.web.dto.response.CandidatureResponseDto;

import java.util.List;

public interface CandidatureService {
    CandidatureResponseDto apply(CreateCandidatureDto dto);

    CandidatureResponseDto applyLoggedUser(Long jobVacancyId, String username);
    List<CandidatureResponseDto> getAll();
    CandidatureResponseDto updateStatus(Long candidatureId, StatusCandidature status);
    CandidatureResponseDto userUpdateStatus(Long candidatureId, StatusCandidature status, String username);

}
