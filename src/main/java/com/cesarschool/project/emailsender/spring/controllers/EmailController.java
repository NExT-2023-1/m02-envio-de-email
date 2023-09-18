package com.cesarschool.project.emailsender.spring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesarschool.project.emailsender.spring.dto.response.GenericResponseDTO;
import com.cesarschool.project.emailsender.spring.services.EmailServices;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/email")
public class EmailController {
	private final EmailServices service;

	@PostMapping(value="/{id}/name={name}")
	public ResponseEntity<GenericResponseDTO> sendMessageToUser(@PathVariable(value="id") String idMessage,
			@PathVariable(value="name") String idUser) {
		return new ResponseEntity<GenericResponseDTO>(service.sendMessageByName(idMessage, idUser),
				HttpStatus.OK);
	}

	@PostMapping(value="/{id}/org={organization}")
	public ResponseEntity<GenericResponseDTO> sendMessageByOrganization(@PathVariable(value="id") String idMessage,
			@PathVariable(value="organization") String organization) {
		return new ResponseEntity<GenericResponseDTO>(service.sendMessageByOrganization(idMessage, organization),
				HttpStatus.OK);
	}

}
