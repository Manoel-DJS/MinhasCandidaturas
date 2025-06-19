package com.tec.api_candidatura.web.controller;

import com.tec.api_candidatura.service.CandidatureService;
import com.tec.api_candidatura.web.dto.request.ApplyToVacancyDto;
import com.tec.api_candidatura.web.dto.request.CreateCandidatureDto;
import com.tec.api_candidatura.web.dto.request.UpdateCandidatureStatusDto;
import com.tec.api_candidatura.web.dto.response.CandidatureResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @PostMapping("/apply")
    public ResponseEntity<CandidatureResponseDto> applyAsLoggedUser(
            @RequestBody ApplyToVacancyDto dto,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        CandidatureResponseDto response = candidatureService.applyLoggedUser(dto.jobVacancyId(), userDetails.getUsername());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<CandidatureResponseDto> updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateCandidatureStatusDto dto
    ) {
        CandidatureResponseDto response = candidatureService.updateStatus(id, dto.status());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/my/{id}/status")
    public ResponseEntity<CandidatureResponseDto> userUpdateStatus(
            @PathVariable Long id,
            @RequestBody UpdateCandidatureStatusDto dto,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        var response = candidatureService.userUpdateStatus(id, dto.status(), userDetails.getUsername());
        return ResponseEntity.ok(response);
    }




    @GetMapping
    public ResponseEntity<List<CandidatureResponseDto>> getAll() {
        return ResponseEntity.ok(candidatureService.getAll());
    }
}
