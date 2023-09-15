package com.vidyuttech.PII.controller.kyc.response;
import lombok.Data;

@Data
public class BaseResponse {
    private ResponseStatus status;

    public BaseResponse(ResponseStatus responseStatus) {
        this.setStatus(responseStatus);
    }

    public BaseResponse() {
        this.status = ResponseStatus.OKAY;
    }
}
