package com.cesarschool.project.emailsender.spring.entities;



import org.hibernate.annotations.UuidGenerator;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

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
@Table(name = "messages")
public class Message {
	@Id
	@UuidGenerator
	@Column
	private String id;
	
	@Column
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
}
