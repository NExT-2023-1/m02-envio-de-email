package com.cesarschool.project.emailsender.spring.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cesarschool.project.emailsender.spring.dto.request.UserRequestDTO;
import com.cesarschool.project.emailsender.spring.dto.response.GenericResponseDTO;
import com.cesarschool.project.emailsender.spring.entities.User;
import com.cesarschool.project.emailsender.spring.exceptions.GeneralException;
import com.cesarschool.project.emailsender.spring.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServices {
	
	private final UserRepository repository;
		
	public GenericResponseDTO createUser(UserRequestDTO request) {
		
		Optional.ofNullable(repository.findByEmail(request.getEmail()))
		.ifPresentOrElse(user -> {
			throw new GeneralException("Usuário já cadastrado", HttpStatus.CONFLICT);
		}, () -> {
			User entity = new User();
			BeanUtils.copyProperties(request, entity);
			repository.save(entity);
		});
		return GenericResponseDTO.builder().message("Usuário cadastrado com sucesso").status(HttpStatus.CREATED).build();
	}



	public User getUser(String id) {
		return repository.findById(id).orElse(null);

	}







	/*
	public User getUserById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {           
           GenericResponseDTO genericResponseDTO = new GenericResponseDTO("Usuário encontrado.", user);
            return new ResponseEntity<>(genericResponseDTO, HttpStatus.OK);
        } else {
           GenericResponseDTO genericResponseDTO = new GenericResponseDTO("Oops, usuário não encontrado...", null);
            return new ResponseEntity<>(genericResponseDTO, HttpStatus.NOT_FOUND);
            // Caso o usuário não seja encontrado
    	}
	}
*/

}

