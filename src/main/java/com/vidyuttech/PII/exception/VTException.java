package com.vidyuttech.PII.exception;

public class VTException extends RuntimeException {

    public VTException(String message, Throwable cause) {
        super(message, cause);
    }

    public VTException(String message) {
        super(message);
    }
}
