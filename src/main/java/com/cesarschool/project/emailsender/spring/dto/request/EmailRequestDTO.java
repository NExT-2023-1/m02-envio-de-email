package com.cesarschool.project.emailsender.spring.dto.request;

import com.cesarschool.project.emailsender.spring.enums.StatusMail;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailRequestDTO {


	@NotBlank
	private String subject;
	
	@NotBlank
	private String text;

	@NotBlank
	private StatusMail statusMail;
}
