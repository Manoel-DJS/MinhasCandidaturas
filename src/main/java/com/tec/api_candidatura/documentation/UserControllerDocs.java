package com.tec.api_candidatura.documentation;

import com.tec.api_candidatura.web.dto.request.UpdateUserDto;
import com.tec.api_candidatura.web.dto.response.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Tag(name = "Usuários", description = "Endpoints para gerenciamento de usuários")
public interface UserControllerDocs {
    @Operation(summary = "Verificar status da API", description = "Retorna 'OK' para indicar que a API está ativa")
    @GetMapping("/ok")
    String ReturnOK();

    @Operation(summary = "Obter ID do usuário logado", description = "Retorna o UUID do usuário autenticado atualmente")
    @GetMapping("/getIdUser")
    String getCurrentUserId(Authentication authentication);

    @Operation(summary = "Atualizar usuário", description = "Atualiza os dados de um usuário existente com base no ID")
    @PutMapping("/{id}")
    ResponseEntity<UserResponseDto> update(@PathVariable UUID id, @RequestBody UpdateUserDto dto);

    @Operation(summary = "Listar todos os usuários", description = "Retorna uma lista com todos os usuários cadastrados")
    @GetMapping("/getAllUsers")
    ResponseEntity<List<UserResponseDto>> list();
}
