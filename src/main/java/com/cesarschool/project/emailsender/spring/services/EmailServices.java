package com.cesarschool.project.emailsender.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cesarschool.project.emailsender.spring.dto.request.EmailRequestDTO;
import com.cesarschool.project.emailsender.spring.dto.response.GenericResponseDTO;
import com.cesarschool.project.emailsender.spring.entities.Email;
import com.cesarschool.project.emailsender.spring.entities.User;
import com.cesarschool.project.emailsender.spring.enums.StatusMail;
import com.cesarschool.project.emailsender.spring.exceptions.GeneralException;
import com.cesarschool.project.emailsender.spring.repositories.EmailRepository;
import com.cesarschool.project.emailsender.spring.repositories.MessageRepository;
import com.cesarschool.project.emailsender.spring.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailServices {

	private final MessageRepository messageRepository;

	private final UserRepository userRepository;

	private final JavaMailSender mailSender;

	private final EmailRepository emailRepository;

	public GenericResponseDTO sendMessageByOrganization(String idMessage, String organization) {

		Optional.ofNullable(messageRepository.findById(idMessage)).ifPresentOrElse(message -> {
			Optional.ofNullable(userRepository.findByOrganization(organization)).ifPresentOrElse(user -> {
				
				EmailRequestDTO e = new EmailRequestDTO();
				
				List<User> u = userRepository.findByOrganization(organization);
				
				try {
					SimpleMailMessage email = new SimpleMailMessage();
					email.setFrom("emailsendernext@gmail.com");
					email.setTo(u.stream().map(User::getEmail).toArray(String[]::new));
					email.setSubject(message.get().getSubject());
					email.setText(message.get().getText());
					mailSender.send(email);

					e.setStatusMail(StatusMail.SENT);
				} catch (MailException ex) {
					e.setStatusMail(StatusMail.ERROR);
					throw new GeneralException("ERROR SENDING THE EMAIL", HttpStatus.BAD_GATEWAY);
				} finally {
					
					List<Email> mailSent = new ArrayList<>();
					
					for (User users : u) {
						
						Email entity = new Email();
						
						e.setUser(users);
						e.setSendTo(users.getEmail());
						e.setSubject(message.get().getSubject());
						e.setText(message.get().getText());
						BeanUtils.copyProperties(e, entity);
						mailSent.add(entity);
					}

					emailRepository.saveAll(mailSent);

				}
			}, () -> {
				throw new GeneralException("USER NOT FOUND IN OUR DATABASE", HttpStatus.NOT_FOUND);
			});
		}, () -> {

			throw new GeneralException("MESSAGE NOT FOUND IN OUR DATABASE", HttpStatus.NOT_FOUND);
		});

		return GenericResponseDTO.builder().message("SENT").status(HttpStatus.OK).build();

	}
}
