package com.cesarschool.project.emailsender.spring.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "user")
public class User {
	@Id
	@UuidGenerator
	@Column
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique=true)
	private String email;
	
	@Column(nullable = false)
	private String organization;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Email> emailsReceived;

	@Column(name = "registration_date")
	private LocalDateTime registrationDate = LocalDateTime.now();
}
