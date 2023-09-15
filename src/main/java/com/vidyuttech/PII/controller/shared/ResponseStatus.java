package com.vidyuttech.PII.controller.shared;


public enum ResponseStatus {
    OKAY("OKAY"),
    FAILED("FAILED");

    private String responseStatus;

    ResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public String toString() {
        return this.responseStatus;
    }
}

