package com.vidyuttech.PII.controller.kyc;


import com.vidyuttech.PII.controller.kyc.request.KycCheckRequest;
import com.vidyuttech.PII.controller.kyc.request.KycCreateRequest;
import com.vidyuttech.PII.controller.kyc.request.KycUpdateRequest;
import com.vidyuttech.PII.controller.kyc.response.BaseResponse;
import com.vidyuttech.PII.data.entities.KycData;
import com.vidyuttech.PII.service.kyc.KycService;
import com.vidyuttech.PII.service.kyc.response.KycResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class KycController {

    private KycService kycService;
    @Autowired
    KycController(KycService kycService){
        this.kycService = kycService;
    }

    @PostMapping("/kyc/create")
    public KycResponse createKyc(@RequestBody KycCreateRequest kycCreateRequest){
        return kycService.createKyc(kycCreateRequest);
    }

    @PostMapping("/kyc/check")
    public KycResponse fetchKyc(@RequestBody KycCheckRequest kycCheckRequest) {
        return kycService.fetchKyc(kycCheckRequest);
    }

    @GetMapping("/kyc/{kycId}")
    public KycResponse getKycData(@PathVariable Long kycId){
        KycData kycData = kycService.findById(kycId);
        return new KycResponse(kycData);
    }

    @PostMapping("/kyc/update")
    public KycResponse updateKyc(@RequestBody KycUpdateRequest kycUpdateRequest){
        return kycService.updateKyc(kycUpdateRequest);
    }



}
