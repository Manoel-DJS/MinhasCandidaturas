package com.tec.api_candidatura.web.dto.response;

public record ErrorResponseDto(
        String error,
        String message,
        int status,
        String timestamp

) {
    public ErrorResponseDto(String error, String message, int status){
        this(error, message, status, java.time.LocalDateTime.now().toString());
    }
}
