package com.aula.pos.appinscricao.exception;

import org.springframework.http.HttpStatus;

public class BusinessRuleException extends ApiException {
    public BusinessRuleException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
