package com.vidyuttech.PII.controller.kyc.request;

import com.vidyuttech.PII.data.enums.DocType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KycCheckRequest {

    private DocType docType;
    private String data;
}
