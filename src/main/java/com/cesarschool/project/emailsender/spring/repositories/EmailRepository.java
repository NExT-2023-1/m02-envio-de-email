package com.cesarschool.project.emailsender.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesarschool.project.emailsender.spring.entities.Email;
import com.cesarschool.project.emailsender.spring.entities.User;



public interface EmailRepository extends JpaRepository<Email, String>{

    User findByUser(User user);
}
