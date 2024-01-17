package com.ob.tsb.accounts.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<ServerResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ServerResponse.status(HttpStatus.NOT_FOUND)
                .bodyValue(new CustomException(ex.getMessage(), "Resource Not  Found"));
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Mono<ServerResponse> handleUnauthorizedException(UnauthorizedException ex) {
        return ServerResponse.status(HttpStatus.FORBIDDEN)
                .bodyValue(new CustomException(ex.getMessage(), "Permission denied"));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ServerResponse> globalExceptionHandler(Exception ex, WebRequest request) {
        return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .bodyValue(new CustomException(ex.getMessage(), "Something went wrong"));
    }



}
