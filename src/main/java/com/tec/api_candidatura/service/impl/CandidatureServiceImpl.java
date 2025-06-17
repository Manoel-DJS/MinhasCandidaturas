package com.tec.api_candidatura.service.impl;

import com.tec.api_candidatura.entity.Candidature;
import com.tec.api_candidatura.repository.CandidatureRepository;
import com.tec.api_candidatura.repository.JobVacancyRepository;
import com.tec.api_candidatura.repository.UserRepository;
import com.tec.api_candidatura.service.CandidatureService;
import com.tec.api_candidatura.web.dto.request.CreateCandidatureDto;
import com.tec.api_candidatura.web.dto.response.CandidatureResponseDto;
import com.tec.api_candidatura.web.dto.response.JobVacancyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatureServiceImpl implements CandidatureService {

    private final CandidatureRepository candidatureRepository;
    private final UserRepository userRepository;
    private final JobVacancyRepository jobVacancyRepository;
    @Override
    public CandidatureResponseDto apply(CreateCandidatureDto dto) {
        return null;
    }

    @Override
    public List<CandidatureResponseDto> getAll() {
        return null;
    }



    private CandidatureResponseDto toDto(Candidature c) {
        return new CandidatureResponseDto(
                c.getId(),
                c.getClass().getName(), // vai da erro aqui
                c.getJobVacancy().getJobTitle(),
                c.getStatusCandidature());
    }

    /**
     *
     * OK
     private CandidatureResponseDto toDto(Candidature c) {
     CandidatureResponseDto dto = new CandidatureResponseDto();
     dto.setId(c.getId());
     dto.setUserName("teste");
     dto.setJobTitle(c.getJobVacancy().getJobTitle());
     dto.setStatus(c.getStatusCandidature());
     return dto;
     }

     private CandidatureResponseDto toDto(Candidature c) {
     return new CandidatureResponseDto(
     c.getId(),
     c.getClass().getName(),
     c.getJobVacancy().getJobTitle(),
     c.getStatusCandidature());
     }
     private CandidatureResponseDto toDto(Candidature c) {
     return new CandidatureResponseDto(
     c.getId(),
     c.getJobVacancy().getUser().getUsername() ,
     c.getJobVacancy().getJobTitle(),
     c.getStatusCandidature());
     }

     */
}
