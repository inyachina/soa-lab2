package com.soa.lab2.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoEntityException extends RuntimeException {

    public NoEntityException(String message) {
        super(message);
    }
}