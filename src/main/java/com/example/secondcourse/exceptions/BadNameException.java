package com.example.secondcourse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class BadNameException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "$$$$$$ BAD NAME $$$$$$";

    public BadNameException() {
        super(DEFAULT_MESSAGE);
    }
}
