package com.tec.api_candidatura.service.impl;

import com.tec.api_candidatura.service.CandidatureService;
import com.tec.api_candidatura.web.dto.request.CreateCandidatureDto;
import com.tec.api_candidatura.web.dto.response.CandidatureResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatureServiceImpl implements CandidatureService {

    @Override
    public CandidatureResponseDto apply(CreateCandidatureDto dto) {
        return null;
    }

    @Override
    public List<CandidatureResponseDto> getAll() {
        return null;
    }
}
