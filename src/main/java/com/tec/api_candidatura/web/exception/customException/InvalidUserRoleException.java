package com.tec.api_candidatura.web.exception.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
public class InvalidUserRoleException extends RuntimeException {
    public InvalidUserRoleException(String role) {
        super("Valor inválido para role: '" + role + "'. Valores esperados: 'USER'");
    }
}