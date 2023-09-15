package com.vidyuttech.PII.controller.kyc.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KycCreateRequest {

    private String aadhaar;
    private String pan;
}
