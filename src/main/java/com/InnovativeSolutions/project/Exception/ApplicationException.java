package com.InnovativeSolutions.project.Exception;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {

    private HttpStatus httpStatus ;
    private String message ;

    public ApplicationException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ApplicationException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
