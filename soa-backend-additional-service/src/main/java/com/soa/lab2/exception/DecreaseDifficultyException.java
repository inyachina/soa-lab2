package com.soa.lab2.exception;

import lombok.Getter;

import javax.ejb.ApplicationException;
import javax.ws.rs.core.Response;

@Getter
@ApplicationException
public class DecreaseDifficultyException extends RuntimeException {
    private final Response.Status status = Response.Status.NOT_ACCEPTABLE;
    private String message;

    public DecreaseDifficultyException(String message) {
        super(message);
    }
}
