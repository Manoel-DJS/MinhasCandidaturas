package com.tec.api_candidatura.web.controller;

import com.tec.api_candidatura.service.CandidatureService;
import com.tec.api_candidatura.web.dto.request.CreateCandidatureDto;
import com.tec.api_candidatura.web.dto.response.CandidatureResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v7/candidatures")
@RequiredArgsConstructor
public class CandidatureController {

    private final CandidatureService candidatureService;

    @PostMapping
    public ResponseEntity<CandidatureResponseDto> apply(@RequestBody CreateCandidatureDto dto) {
        return ResponseEntity.ok(candidatureService.apply(dto));
    }

    @GetMapping
    public ResponseEntity<List<CandidatureResponseDto>> getAll() {
        return ResponseEntity.ok(candidatureService.getAll());
    }
}
