package com.cesarschool.project.emailsender.spring.dto.response;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericResponseDTO {
	
	private String message;
	
	private HttpStatus status;
}