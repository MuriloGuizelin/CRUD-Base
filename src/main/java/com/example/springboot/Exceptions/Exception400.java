package com.example.springboot.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class Exception400 extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public Exception400(String errorMessage) {
        super(errorMessage);
    }
}
