package com.tec.api_candidatura.service.impl;

import com.tec.api_candidatura.entity.Candidature;
import com.tec.api_candidatura.entity.JobVacancy;
import com.tec.api_candidatura.entity.User;
import com.tec.api_candidatura.entity.enums.StatusCandidature;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidatureServiceImpl implements CandidatureService {

    private final CandidatureRepository candidatureRepository;
    private final UserRepository userRepository;
    private final JobVacancyRepository jobVacancyRepository;
    @Override
    public CandidatureResponseDto apply(CreateCandidatureDto dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        JobVacancy vacancy = jobVacancyRepository.findById(dto.jobVacancyId())
                .orElseThrow(() -> new RuntimeException("Job vacancy not found"));

        // Verifica se o usuário já se candidatou a esta vaga
        Optional<Candidature> existing = candidatureRepository
                .findByUserIdAndJobVacancyId(user.getId(), vacancy.getId());

        if (existing.isPresent()) {
            throw new RuntimeException("User has already applied to this job vacancy.");
        }

        Candidature candidature = new Candidature();
        candidature.setUser(user);
        candidature.setJobVacancy(vacancy);
        candidature.setStatusCandidature(StatusCandidature.SUBMITTED);

        candidatureRepository.save(candidature);

        return toDto(candidature);
    }

    @Override
    public CandidatureResponseDto applyLoggedUser(Long jobVacancyId, String username) {
        User user = (User) userRepository.findByName(username);
        if (user == null) {
            throw new RuntimeException("Authenticated user not found");
        }

        JobVacancy vacancy = jobVacancyRepository.findById(jobVacancyId)
                .orElseThrow(() -> new RuntimeException("Job vacancy not found"));

        Candidature candidature = new Candidature();
        candidature.setUser(user);
        candidature.setJobVacancy(vacancy);
        candidature.setStatusCandidature(StatusCandidature.SUBMITTED);

        candidatureRepository.save(candidature);
        return toDto(candidature);
    }

    @Override
    public List<CandidatureResponseDto> getAll() {
        return candidatureRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }



    private CandidatureResponseDto toDto(Candidature c) {
        return new CandidatureResponseDto(
                c.getId(),
                c.getUser().getName(), // vai da erro aqui
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
