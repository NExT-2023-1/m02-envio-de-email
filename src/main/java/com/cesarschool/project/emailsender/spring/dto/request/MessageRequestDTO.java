package com.cesarschool.project.emailsender.spring.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MessageRequestDTO {
	
	@NotBlank
	private String subject;
	@NotBlank
	private String text;
}
