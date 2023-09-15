package com.vidyuttech.PII.data.enums;

public enum DocType {
    PAN("PAN"),

    AADHAR("AADHAR");

    private String docType;

    DocType(String docType) {
        this.docType = docType;
    }

    @Override
    public String toString() {
        return this.docType;
    }
}
