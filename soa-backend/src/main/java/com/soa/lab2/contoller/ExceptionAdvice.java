package com.soa.lab2.contoller;

import com.soa.lab2.dao.ExceptionResponse;
import com.soa.lab2.exception.NoEntityException;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(PSQLException.class)
    public ResponseEntity handlePSQLException(PSQLException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ExceptionResponse(e.getClass().getName(), e.getMessage()));
    }

    @ExceptionHandler(NoEntityException.class)
    public ResponseEntity handleNoDisciplineException(NoEntityException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(e.getClass().getName(), e.getMessage()));
    }
}
