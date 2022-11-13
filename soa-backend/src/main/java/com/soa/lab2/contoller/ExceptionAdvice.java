package com.soa.lab2.contoller;

import com.soa.lab2.dao.ExceptionResponse;
import com.soa.lab2.exception.EmptyCollectionException;
import com.soa.lab2.exception.NoEntityException;
import com.soa.lab2.exception.ValidationException;
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
                .body(new ExceptionResponse(e.getClass().getName(),
                        (!e.getMessage().isEmpty()) ? e.getMessage() : "Already exists"));
    }

    @ExceptionHandler(NoEntityException.class)
    public ResponseEntity handleNoDisciplineException(NoEntityException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(new ExceptionResponse(e.getClass().getName(),
                        (!e.getMessage().isEmpty()) ? e.getMessage() : "Not found"));
    }

    @ExceptionHandler(EmptyCollectionException.class)
    public ResponseEntity handleEmptyCollectionException(EmptyCollectionException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(new ExceptionResponse(e.getClass().getName(),
                        (!e.getMessage().isEmpty()) ? e.getMessage() : "Empty Collection"));
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity handleNumberFormatException(NumberFormatException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(e.getClass().getName(),
                        (!e.getMessage().isEmpty()) ? e.getMessage() : "Bad request"));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity handleValidationException(ValidationException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(new ExceptionResponse(e.getClass().getName(), e.getMessage()));
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity handleServerException(Exception e) {
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(new ExceptionResponse(e.getClass().getName(), "Something went wrong"));
//    }
}
