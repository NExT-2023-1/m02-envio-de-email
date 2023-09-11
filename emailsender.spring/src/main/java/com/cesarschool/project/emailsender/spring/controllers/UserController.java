package com.cesarschool.project.emailsender.spring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesarschool.project.emailsender.spring.dto.request.UserRequestDTO;
import com.cesarschool.project.emailsender.spring.dto.response.GenericResponseDTO;
import com.cesarschool.project.emailsender.spring.services.UserServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/user")
public class UserController {

	private final UserServices service;
	
	@PostMapping
	public ResponseEntity<GenericResponseDTO> createUser(@RequestBody UserRequestDTO request){
		return new ResponseEntity<GenericResponseDTO>(service.createUser(request), HttpStatus.CREATED);
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<GenericResponseDTO> deleteUser(@PathVariable(name="id") String id){
		return new ResponseEntity<GenericResponseDTO>(service.deleteUser(id), HttpStatus.OK);
	}
}
	