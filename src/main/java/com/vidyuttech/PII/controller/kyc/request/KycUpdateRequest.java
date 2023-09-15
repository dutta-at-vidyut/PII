package com.vidyuttech.PII.controller.kyc.request;

import com.vidyuttech.PII.data.enums.DocType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class KycUpdateRequest {

    private Long kycDataId;
    private DocType docType;
    private String data;
}
