package com.cesarschool.project.emailsender.spring.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class GeneralException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private HttpStatus status;

    private int statusCode;
    
    public GeneralException(String message, HttpStatus status) {
        super(String.format(message));
        this.statusCode = status.value();
        this.status = status;
    }
}
