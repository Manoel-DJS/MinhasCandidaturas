package com.tec.api_candidatura.web.controller;

import com.tec.api_candidatura.service.JobVacancyService;
import com.tec.api_candidatura.web.dto.request.CreateJobVacancyDto;
import com.tec.api_candidatura.web.dto.request.UpdateJobVacancyDto;
import com.tec.api_candidatura.web.dto.response.JobVacancyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v7/vacancies")
@RequiredArgsConstructor
public class JobVacancyController {

    private final JobVacancyService jobVacancyService;

    @PostMapping
    public ResponseEntity<JobVacancyResponseDto> create(@RequestBody CreateJobVacancyDto dto) {
        return ResponseEntity.ok(jobVacancyService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobVacancyResponseDto> update(@PathVariable Long id, @RequestBody UpdateJobVacancyDto dto) {
        return ResponseEntity.ok(jobVacancyService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jobVacancyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<JobVacancyResponseDto>> getAll() {
        return ResponseEntity.ok(jobVacancyService.findAll());
    }

}
