package com.tec.api_candidatura.service;

import com.tec.api_candidatura.web.dto.request.CreateCandidatureDto;
import com.tec.api_candidatura.web.dto.response.CandidatureResponseDto;

import java.util.List;

public interface CandidatureService {
    CandidatureResponseDto apply(CreateCandidatureDto dto);
    List<CandidatureResponseDto> getAll();
}
