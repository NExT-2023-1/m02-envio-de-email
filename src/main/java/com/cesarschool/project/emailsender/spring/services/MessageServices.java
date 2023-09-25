package com.cesarschool.project.emailsender.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cesarschool.project.emailsender.spring.dto.request.MessageRequestDTO;
import com.cesarschool.project.emailsender.spring.dto.response.GenericResponseDTO;
import com.cesarschool.project.emailsender.spring.entities.Message;
import com.cesarschool.project.emailsender.spring.exceptions.GeneralException;
import com.cesarschool.project.emailsender.spring.repositories.MessageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MessageServices {

	private final MessageRepository repository;

	public GenericResponseDTO createMessage(MessageRequestDTO message) {
		Message entity = new Message();
		BeanUtils.copyProperties(message, entity);
		repository.save(entity);
		return GenericResponseDTO.builder().message("MESSAGE ADDED SUCCESSFULLY").status(HttpStatus.CREATED)
				.build();
	}

	public List<Message> findAll() {
		return repository.findAll();
	}

	public Message findById(String message) {
		return repository.findById(message)
				.orElseThrow(() -> new GeneralException("MESSAGE NOT FOUND IN OUR DATABASE", HttpStatus.NOT_FOUND));
	}

	public Message findBySubject(String subject) {
		return repository.findBySubject(subject);

	}

	public GenericResponseDTO deleteMessage(String id) {
		Optional.ofNullable(repository.findById(id).orElse(null)).ifPresentOrElse(message -> {
			repository.deleteById(id);
		}, () -> {
			throw new GeneralException("MESSAGE NOT FOUND IN OUR DATABASE", HttpStatus.NOT_FOUND);
		});
		return GenericResponseDTO.builder().message("MESSAGE DELETED").status(HttpStatus.OK).build();
	}
}
