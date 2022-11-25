package com.soa.lab2.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NoEntityException extends ApiException {

    public NoEntityException() {
        super(HttpStatus.NOT_FOUND, "Entity is not found");
    }

    public NoEntityException(String message) {
        this();
        super.message = message;
    }

}