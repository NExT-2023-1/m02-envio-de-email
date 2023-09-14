package com.cesarschool.project.emailsender.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesarschool.project.emailsender.spring.services.MessageServices;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/message")
public class MessageController {
	@Autowired
	private final MessageServices service;
	
	
	

}
