package com.ob.tsb.accounts.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.*;

public class ErrorDesc {


    public static Mono<? extends Throwable> handle5xxClientError(String msg, ClientResponse clientResponse) {
        HttpStatusCode httpStatusCode = clientResponse.statusCode();
        switch (httpStatusCode) {
            default -> {
                throw new CustomException(httpStatusCode, msg + " have Server Error");
            }
        }
    }

    public static Mono<? extends Throwable> handle4xxClientError(String msg, ClientResponse clientResponse) {
        HttpStatusCode httpStatusCode = clientResponse.statusCode();

        switch (httpStatusCode) {
            case NOT_FOUND -> {
                throw new ResourceNotFoundException(httpStatusCode, msg + " Client API Not Found");
            }
            case UNAUTHORIZED -> {
                throw new UnauthorizedException(httpStatusCode, msg + " Authorization Failed");
            }
            case NOT_ACCEPTABLE -> {
                throw new ResourceNotFoundException(httpStatusCode, msg + " Client Url Not Accepted"); //throw new IllegalStateException("Unexpected value: " + httpStatusCode);
            }
            default -> {
                throw new ResourceNotFoundException(httpStatusCode, msg); //throw new IllegalStateException("Unexpected value: " + httpStatusCode);
            }
        }
    }
}
