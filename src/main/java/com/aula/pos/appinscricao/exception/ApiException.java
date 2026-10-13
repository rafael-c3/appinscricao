package com.aula.pos.appinscricao.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ApiException extends RuntimeException{
    private final HttpStatus status;

    public ApiException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }
}
