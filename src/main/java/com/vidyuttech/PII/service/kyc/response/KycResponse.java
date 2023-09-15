package com.vidyuttech.PII.service.kyc.response;

import com.vidyuttech.PII.controller.kyc.response.BaseResponse;
import com.vidyuttech.PII.controller.kyc.response.ResponseStatus;
import com.vidyuttech.PII.data.entities.KycData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KycResponse extends BaseResponse {

    public Long kycDataId;
    public String aadhaarNumber;
    public String panNumber;
    public KycResponse(KycData kycData){
        super(ResponseStatus.OKAY);
        this.kycDataId = kycData.getId();
        this.aadhaarNumber = kycData.getAadhaarNumber();
        this.panNumber = kycData.getPanNumber();
    }

}
