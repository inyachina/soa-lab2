package com.soa.lab2.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EmptyCollectionException extends ApiException {

    public EmptyCollectionException() {
        super(HttpStatus.NO_CONTENT, "Collection is empty");
    }

    public EmptyCollectionException(String message) {
        this();
        super.message = message;
    }

}
