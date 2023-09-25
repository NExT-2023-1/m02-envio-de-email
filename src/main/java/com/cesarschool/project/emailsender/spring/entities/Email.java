package com.cesarschool.project.emailsender.spring.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import com.cesarschool.project.emailsender.spring.enums.StatusMail;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@Entity
@Table(name = "emails")
public class Email {
	@Id
	@UuidGenerator
	@Column
	private String id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "send_from")
	private String sendFrom = "emailsendernext@gmail.com";
	
	@Column(name = "send_to")
	private String sendTo;
	
	@Column
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	@Column(name = "date_sent")
	private LocalDateTime dateSent = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status_mail")
	private StatusMail statusMail;
	
}
