package com.cesarschool.project.emailsender.spring.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageRequestDTO {
	@NotNull
	private String subject;
	@NotNull
	private String text;
}
