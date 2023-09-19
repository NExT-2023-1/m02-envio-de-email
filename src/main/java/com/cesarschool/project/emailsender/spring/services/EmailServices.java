package com.cesarschool.project.emailsender.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cesarschool.project.emailsender.spring.dto.response.GenericResponseDTO;
import com.cesarschool.project.emailsender.spring.entities.Email;
import com.cesarschool.project.emailsender.spring.entities.User;
import com.cesarschool.project.emailsender.spring.enums.StatusMail;
import com.cesarschool.project.emailsender.spring.exceptions.GeneralException;
import com.cesarschool.project.emailsender.spring.repositories.MessageRepository;
import com.cesarschool.project.emailsender.spring.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailServices {

	private final MessageRepository messageRepository;

	private final UserRepository userRepository;

	private final JavaMailSender mailSender;


	public GenericResponseDTO sendMessageByOrganization(String idMessage, String organization) {

		Email e = new Email();
		Optional.ofNullable(messageRepository.findById(idMessage)).ifPresentOrElse(message -> {
			Optional.ofNullable(userRepository.findByOrganization(organization)).ifPresentOrElse(user -> {

				List<User> u = userRepository.findByOrganization(organization);

				SimpleMailMessage email = new SimpleMailMessage();
				email.setFrom("emailsendernext@gmail.com");
				email.setTo(u.stream().map(User::getEmail).toArray(String[]::new));
				email.setSubject(message.get().getSubject());
				email.setText(message.get().getText());
				mailSender.send(email);

				e.setStatusMail(StatusMail.SENT);

				//SALVAR EMAIL NO BANCO DE DADOS

			}, () -> {
				throw new GeneralException("USER NOT FOUND IN OUR DATABASE", HttpStatus.NOT_FOUND);
			});
		}, () -> {

			throw new GeneralException("MESSAGE NOT FOUND IN OUR DATABASE", HttpStatus.NOT_FOUND);
		});

		return GenericResponseDTO.builder().message("SENT").status(HttpStatus.OK).build();

	}
}
