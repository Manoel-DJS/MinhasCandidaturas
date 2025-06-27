package com.tec.api_candidatura.documentation;

import com.tec.api_candidatura.web.dto.request.RegisterUserDto;
import com.tec.api_candidatura.web.dto.request.RequestAuthenticationDto;
import com.tec.api_candidatura.web.dto.response.LoginResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Autenticação", description = "Endpoints para login e registro de usuários")
public interface AuthControllerDocs {

    @Operation(summary = "Autenticar usuário", description = "Realiza login com credenciais válidas e retorna um token JWT")
    @PostMapping("/login")
    ResponseEntity<LoginResponseDto> login(@RequestBody @Valid RequestAuthenticationDto dto);

    @Operation(summary = "Registrar novo usuário", description = "Cria uma nova conta de usuário com os dados fornecidos")
    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody @Valid RegisterUserDto dto);
}
