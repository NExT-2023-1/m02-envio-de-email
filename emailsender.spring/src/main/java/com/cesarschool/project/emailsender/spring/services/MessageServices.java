package com.cesarschool.project.emailsender.spring.services;

import org.springframework.stereotype.Service;

import com.cesarschool.project.emailsender.spring.repositories.MessageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MessageServices {
	
	private final MessageRepository repository;
	
	
	
	
}
