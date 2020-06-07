package com.spring.exception;

import com.spring.exception.error.ErrorClass;

public class StudioUserException extends RuntimeException{
    private ErrorClass errorClass;

    public StudioUserException(String message, ErrorClass errorClass) {
        super(message);
        this.errorClass = errorClass;
    }

    public StudioUserException(ErrorClass errorClass, Throwable cause) {
        super(cause);
    }

}
