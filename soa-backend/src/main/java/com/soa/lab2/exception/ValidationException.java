package com.soa.lab2.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
public class ValidationException extends RuntimeException {
    private final HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    public ValidationException(String message) {
        super(message);
    }

}