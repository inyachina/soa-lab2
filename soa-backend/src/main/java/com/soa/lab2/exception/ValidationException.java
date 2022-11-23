package com.soa.lab2.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
//todo remove
public class ValidationException extends LabException {

    public ValidationException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Validation failed");
    }

    public ValidationException(String message) {
        this();
        super.message = message;
    }

}