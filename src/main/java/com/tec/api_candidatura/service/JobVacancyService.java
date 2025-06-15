package com.tec.api_candidatura.service;

import com.tec.api_candidatura.web.dto.request.CreateJobVacancyDto;
import com.tec.api_candidatura.web.dto.request.UpdateJobVacancyDto;
import com.tec.api_candidatura.web.dto.response.JobVacancyResponseDto;

import java.util.List;

public interface JobVacancyService {
    JobVacancyResponseDto create(CreateJobVacancyDto dto);
    JobVacancyResponseDto update(Long id, UpdateJobVacancyDto dto);
    void delete(Long id);
    List<JobVacancyResponseDto> findAll();
}
