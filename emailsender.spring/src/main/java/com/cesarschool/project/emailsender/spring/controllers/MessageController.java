package com.cesarschool.project.emailsender.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesarschool.project.emailsender.spring.services.MessageServices;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/message")
public class MessageController {
	
	private final MessageServices service;
	
	

}
