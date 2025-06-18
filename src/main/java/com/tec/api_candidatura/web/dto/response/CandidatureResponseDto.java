package com.tec.api_candidatura.web.dto.response;

import com.tec.api_candidatura.entity.enums.StatusCandidature;

public record CandidatureResponseDto(Long id, String userName, String jobTitle, StatusCandidature status) {
}

/**

 @Data
 public class CandidatureResponseDto {
 private Long id;
 private String userName;
 private String jobTitle;
 private StatusCandidature status;
 }

 */