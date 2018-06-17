package com.brijinc.config.utils.exception;

import org.springframework.validation.BindingResult;

/**
 * Exception used in the case of invalid request.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 * 
 */
public class InvalidRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final transient BindingResult errors;

    public InvalidRequestException(BindingResult errors) {
        this.errors = errors;
    }

    public BindingResult getErrors() {
        return this.errors;
    }
}
