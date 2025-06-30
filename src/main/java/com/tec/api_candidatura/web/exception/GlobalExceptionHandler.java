package com.tec.api_candidatura.web.exception;

import com.tec.api_candidatura.web.dto.response.ErrorResponseDto;
import com.tec.api_candidatura.web.exception.customException.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
