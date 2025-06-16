package com.tec.api_candidatura.web.controller;

import com.tec.api_candidatura.service.JobVacancyService;
import com.tec.api_candidatura.web.dto.request.CreateJobVacancyDto;
import com.tec.api_candidatura.web.dto.response.JobVacancyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v7/vacancies")
@RequiredArgsConstructor
public class JobVacancyController {

    private final JobVacancyService jobVacancyService;

    @PostMapping
    public ResponseEntity<JobVacancyResponseDto> create(@RequestBody CreateJobVacancyDto dto) {
        return ResponseEntity.ok(jobVacancyService.create(dto));
    }
}
