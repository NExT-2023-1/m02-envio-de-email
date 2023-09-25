package com.cesarschool.project.emailsender.spring.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesarschool.project.emailsender.spring.dto.request.MessageRequestDTO;
import com.cesarschool.project.emailsender.spring.dto.response.GenericResponseDTO;
import com.cesarschool.project.emailsender.spring.entities.Message;
import com.cesarschool.project.emailsender.spring.services.MessageServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/message")
public class MessageController {

	private final MessageServices service;

	@PostMapping
	public ResponseEntity<GenericResponseDTO> createMessage(@RequestBody @Valid MessageRequestDTO request){
		return new ResponseEntity<GenericResponseDTO>(service.createMessage(request), HttpStatus.CREATED);
	}

  	@GetMapping
	public ResponseEntity<List<Message>> findAll(){
		return new ResponseEntity<List<Message>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(value="/{subject}")
	public ResponseEntity<Message> findById(@PathVariable(name ="subject") String subject){
		 return new ResponseEntity<Message>(service.findBySubject(subject), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<GenericResponseDTO> deleteMessage(@PathVariable(name = "id") String id) {
		return new ResponseEntity<GenericResponseDTO>(service.deleteMessage(id), HttpStatus.OK);
	}

}
