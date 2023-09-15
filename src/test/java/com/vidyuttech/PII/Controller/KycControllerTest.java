package com.vidyuttech.PII.Controller;

import com.vidyuttech.PII.controller.kyc.KycController;
import com.vidyuttech.PII.controller.kyc.request.KycCheckRequest;
import com.vidyuttech.PII.data.enums.DocType;
import com.vidyuttech.PII.service.kyc.response.KycResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KycControllerTest {

    @Autowired
    private KycController kycController;

    @Test
    public void shouldReturnKycDataForExistingPanNumber() {
        KycResponse kycResponse = kycController.fetchKyc(
                new KycCheckRequest(DocType.PAN, "ValidPANNumber"));
        Assertions.assertNotNull(kycResponse.getPanNumber());
    }

    @Test
    public void shouldReturnKycDataForExistingAadhaarNumber() {
        KycResponse kycResponse = kycController.fetchKyc(
                new KycCheckRequest(DocType.AADHAR, "ValidAadhaarNumber"));
        Assertions.assertNotNull(kycResponse.getAadhaarNumber());
    }



}
