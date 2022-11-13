package com.soa.lab2.exception;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
public class EmptyCollectionException extends RuntimeException {
    private final HttpStatus status = HttpStatus.NO_CONTENT;

    public EmptyCollectionException(String message) {
        super(message);
    }

}
