package com.soa.lab2.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RSQLException extends ApiException {
    public RSQLException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "This value is not supported for filtering");
    }

    public RSQLException(String message) {
        this();
        super.message = message;
    }
}
