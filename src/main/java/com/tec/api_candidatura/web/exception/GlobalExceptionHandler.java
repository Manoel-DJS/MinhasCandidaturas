package com.tec.api_candidatura.web.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.tec.api_candidatura.entity.enums.UserRole;
import com.tec.api_candidatura.web.dto.response.ErrorResponseDto;
import com.tec.api_candidatura.web.exception.customException.InvalidCredentialsException;
import com.tec.api_candidatura.web.exception.customException.UserAlreadyExistsException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponseDto handleInvalidCredentials(InvalidCredentialsException ex) {
        return new ErrorResponseDto(
                "Unauthorized",
                ex.getMessage(),
                HttpStatus.UNAUTHORIZED.value()
        );
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseDto handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return new ErrorResponseDto(
                "Conflict",
                ex.getMessage(),
                HttpStatus.CONFLICT.value()
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();

        if (cause instanceof InvalidFormatException formatException) {
            Class<?> targetType = formatException.getTargetType();

            if (targetType.isEnum() && targetType.equals(UserRole.class)) {
                String invalidValue = formatException.getValue().toString();
                return new ErrorResponseDto(
                        "Bad Request",
                        "Role inválida: '" + invalidValue + "'. Valores esperados: 'USER'",
                        HttpStatus.BAD_REQUEST.value()
                );
            }
        }

        return new ErrorResponseDto(
                "Bad Request",
                "Erro ao processar requisição: " + ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
    }


    // exceptions que vou lembrando no processo
    // usuario igual, // commit

}
