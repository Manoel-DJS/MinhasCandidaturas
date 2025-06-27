package com.tec.api_candidatura.documentation;

import com.tec.api_candidatura.web.dto.request.CreateJobVacancyDto;
import com.tec.api_candidatura.web.dto.request.UpdateJobVacancyDto;
import com.tec.api_candidatura.web.dto.response.JobVacancyResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Vagas", description = "Endpoints para gerenciamento de vagas de emprego")
public interface JobVacancyControllerDocs {

    @Operation(summary = "Criar vaga", description = "Cria uma nova vaga de emprego com os dados fornecidos")
    @PostMapping
    ResponseEntity<JobVacancyResponseDto> create(@RequestBody CreateJobVacancyDto dto);

    @Operation(summary = "Atualizar vaga", description = "Atualiza os dados de uma vaga existente com base no ID")
    @PutMapping("/{id}")
    ResponseEntity<JobVacancyResponseDto> update(@PathVariable Long id, @RequestBody UpdateJobVacancyDto dto);

    @Operation(summary = "Excluir vaga", description = "Remove uma vaga do sistema com base no ID")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Listar todas as vagas", description = "Retorna uma lista de todas as vagas de emprego cadastradas")
    @GetMapping
    ResponseEntity<List<JobVacancyResponseDto>> getAll();
}
