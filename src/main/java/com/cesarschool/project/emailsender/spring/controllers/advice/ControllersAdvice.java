package com.cesarschool.project.emailsender.spring.controllers.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cesarschool.project.emailsender.spring.dto.response.GenericResponseDTO;
import com.cesarschool.project.emailsender.spring.exceptions.GeneralException;

@ControllerAdvice
public class ControllersAdvice {

	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<GenericResponseDTO> generalException(GeneralException e) {
		return new ResponseEntity<GenericResponseDTO>(
				GenericResponseDTO.builder().message(e.getMessage()).status(e.getStatus()).build(), e.getStatus());
	}

}
