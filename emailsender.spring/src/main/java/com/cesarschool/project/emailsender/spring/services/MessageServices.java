package com.cesarschool.project.emailsender.spring.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.cesarschool.project.emailsender.spring.entities.Message;
import com.cesarschool.project.emailsender.spring.repositories.MessageRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MessageServices {
	
	private final MessageRepository repository;
	
	public List<Message> findAll() {
		return repository.findAll();
	  }


	  public Optional<Message> findById(String message){
		return repository.findById(message); 

	  }
	
	  public Optional<Message> findBySubject( String message){
		return ((MessageServices) repository).findBySubject(message);
		
	  }
	@Transactional
	public Message save(Message message){
		Message entity = new Message();
		BeanUtils.copyProperties(repository, entity);
		return repository.save(entity);
}

@Transactional
public void delete(Message message) {
  repository.delete(message);
}
	
	
}
