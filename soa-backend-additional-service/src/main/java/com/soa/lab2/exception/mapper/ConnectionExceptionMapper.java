package com.soa.lab2.exception.mapper;

import com.soa.lab2.data.ExceptionResponse;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConnectionExceptionMapper implements ExceptionMapper<ProcessingException> {
    @Override
    public Response toResponse(ProcessingException e) {
        return Response.status(Response.Status.BAD_GATEWAY)
                .entity(new ExceptionResponse(e.getClass().getName(), "Couldn't connect to main service"))
                .build();
    }
}
