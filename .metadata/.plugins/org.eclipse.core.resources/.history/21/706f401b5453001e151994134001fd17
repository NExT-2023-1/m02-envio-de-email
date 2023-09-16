package com.cesarschool.project.emailsender.spring.controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesarschool.project.emailsender.spring.entities.User;
import com.cesarschool.project.emailsender.spring.services.MessageServices;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import javax.security.auth.Subject;

import com.cesarschool.project.emailsender.spring.dto.response.GenericResponseDTO;
import com.cesarschool.project.emailsender.spring.entities.Message;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/message")
public class MessageController {
	@Autowired
	private final MessageServices service;
	

	@GetMapping(value ="/subejct") 
	public ResponseEntity<List<Message>> getMessage(@PathVariable(name ="Subject") String subject){
		 return new ResponseEntity<List<MessageServices>>(service.findBySubject(subject), HttpStatus.OK);
	}

	@DeleteMapping(value = "/id")
	public ResponseEntity<GenericResponseDTO> delMessage(@PathVariable(name="id") String id){
		return new ResponseEntity<GenericResponseDTO>(service.delete(id), HttpStatus.OK);
	}

	
	


}
