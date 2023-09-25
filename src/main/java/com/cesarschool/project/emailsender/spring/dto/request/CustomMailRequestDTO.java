package com.cesarschool.project.emailsender.spring.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomMailRequestDTO {
	
	@Email
	@NotBlank
	private String sendTo;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String text;
	
}
