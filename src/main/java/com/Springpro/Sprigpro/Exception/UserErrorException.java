package com.Springpro.Sprigpro.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserErrorException extends RuntimeException {
    public UserErrorException(String message) {
        super(message);
    }
}
