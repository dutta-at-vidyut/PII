package com.vidyuttech.PII.exception;

public enum ErrorMessage {

    ERROR_SENDING_EMAIL("ERROR_SENDING_EMAIL");

    private String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return this.error;
    }
}
