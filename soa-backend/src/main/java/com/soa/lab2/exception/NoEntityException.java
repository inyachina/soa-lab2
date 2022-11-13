package com.soa.lab2.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
public class NoEntityException extends RuntimeException {
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public NoEntityException(String message) {
        super(message);
    }
}