package com.cesarschool.project.emailsender.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesarschool.project.emailsender.spring.entities.Email;



public interface EmailRepository extends JpaRepository<Email, String>{

}
