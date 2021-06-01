package com.example.demo.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
