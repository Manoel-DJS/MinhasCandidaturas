package com.tec.api_candidatura.documentation;

import com.tec.api_candidatura.web.dto.request.ApplyToVacancyDto;
import com.tec.api_candidatura.web.dto.request.CreateCandidatureDto;
import com.tec.api_candidatura.web.dto.request.UpdateCandidatureStatusDto;
import com.tec.api_candidatura.web.dto.response.CandidatureResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Candidaturas", description = "Endpoints para gerenciamento de candidaturas")
public interface CandidatureControllerDocs {

    @Operation(summary = "Criar candidatura", description = "Realiza a candidatura de um usuário com base no UUID fornecido no corpo da requisição")
    @PostMapping
    ResponseEntity<CandidatureResponseDto> apply(@RequestBody CreateCandidatureDto dto);

    @Operation(summary = "Candidatar-se como usuário logado", description = "Realiza a candidatura automaticamente com base no usuário autenticado")
    @PostMapping("/apply")
    ResponseEntity<CandidatureResponseDto> applyAsLoggedUser(
            @RequestBody ApplyToVacancyDto dto,
            @AuthenticationPrincipal UserDetails userDetails
    );

    @Operation(summary = "Atualizar status da candidatura", description = "Altera o status de uma candidatura específica pelo ID")
    @PatchMapping("/{id}/status")
    ResponseEntity<CandidatureResponseDto> updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateCandidatureStatusDto dto
    );

    @Operation(summary = "Usuário atualiza seu próprio status", description = "Permite que o próprio usuário atualize o status da sua candidatura")
    @PatchMapping("/my/{id}/status")
    ResponseEntity<CandidatureResponseDto> userUpdateStatus(
            @PathVariable Long id,
            @RequestBody UpdateCandidatureStatusDto dto,
            @AuthenticationPrincipal UserDetails userDetails
    );

    @Operation(summary = "Listar todas as candidaturas", description = "Retorna todas as candidaturas registradas no sistema")
    @GetMapping
    ResponseEntity<List<CandidatureResponseDto>> getAll();
}
