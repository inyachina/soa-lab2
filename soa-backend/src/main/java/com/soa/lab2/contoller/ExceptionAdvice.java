package com.soa.lab2.contoller;

import com.soa.lab2.data.ExceptionResponse;
import com.soa.lab2.exception.LabException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(LabException.class)
    public ResponseEntity handleServerException(LabException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(e.getStatus())
                .body(new ExceptionResponse(e.getClass().getName(),
                        (!e.getMessage().isEmpty()) ? e.getMessage() : e.getDefaultMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleServerException(Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(e.getClass().getName(), "Something went wrong"));
    }
}
