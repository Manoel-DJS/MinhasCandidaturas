package com.tec.api_candidatura.service.impl;

import com.tec.api_candidatura.entity.JobVacancy;
import com.tec.api_candidatura.entity.enums.JobVacancyStatus;
import com.tec.api_candidatura.repository.JobVacancyRepository;
import com.tec.api_candidatura.service.JobVacancyService;
import com.tec.api_candidatura.web.dto.request.CreateJobVacancyDto;
import com.tec.api_candidatura.web.dto.request.UpdateJobVacancyDto;
import com.tec.api_candidatura.web.dto.response.JobVacancyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobVacancyServiceImpl implements JobVacancyService {

    private final JobVacancyRepository repository;
    @Override
    public JobVacancyResponseDto create(CreateJobVacancyDto dto) {
        JobVacancy vacancy = new JobVacancy();
        vacancy.setJobTitle(dto.title());
        vacancy.setJobDescription(dto.description());
        vacancy.setJobCompany(dto.jobCompany());
        vacancy.setLocation(dto.location());
        vacancy.setJobVacancyType(dto.type());
        vacancy.setJobVacancyStatus(dto.status());

        repository.save(vacancy);
        return toDto(vacancy);
    }

    @Override
    public JobVacancyResponseDto update(Long id, UpdateJobVacancyDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<JobVacancyResponseDto> findAll() {
        return null;
    }

    private JobVacancyResponseDto toDto(JobVacancy job) {
        return new JobVacancyResponseDto(
                job.getId(),
                job.getJobTitle(),
                job.getJobDescription(),
                job.getJobCompany(),
                job.getLocation(),
                job.getJobVacancyType(),
                job.getJobVacancyStatus()
        );
    }
}
