package com.soa.lab2.exception.mapper;

import com.soa.lab2.data.ExceptionResponse;
import com.soa.lab2.exception.DecreaseDifficultyException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DecreaseDifficultyExceptionMapper implements ExceptionMapper<DecreaseDifficultyException> {

    @Override
    public Response toResponse(DecreaseDifficultyException exception) {
        return Response.status(exception.getStatus())
                .entity(new ExceptionResponse(exception.getClass().getName(), exception.getMessage()))
                .build();
    }
}
