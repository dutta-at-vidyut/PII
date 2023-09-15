package com.vidyuttech.PII.service.kyc;


import com.vidyuttech.PII.controller.kyc.request.KycCheckRequest;
import com.vidyuttech.PII.controller.kyc.request.KycCreateRequest;
import com.vidyuttech.PII.controller.kyc.request.KycUpdateRequest;
import com.vidyuttech.PII.data.entities.KycData;
import com.vidyuttech.PII.data.enums.DocType;
import com.vidyuttech.PII.data.repositories.KycDataRepo;
import com.vidyuttech.PII.exception.VTException;
import com.vidyuttech.PII.service.kyc.response.KycResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


@Transactional
@Service
@Slf4j
public class KycService {

   private KycDataRepo kycDataRepo;

   @Autowired
   KycService(KycDataRepo kycDataRepo){
       this.kycDataRepo = kycDataRepo;
   }

    public Optional<KycData> findByPan(String key) {
        return kycDataRepo.findByPanNumber(key);
    }

    public Optional<KycData> findByAadhaar(String key) {
        return kycDataRepo.findByAadhaarNumber(key);
    }

    public KycData findById(Long id) {
        Optional<KycData> kycDataOptional = kycDataRepo.findById(id);
        if (kycDataOptional.isEmpty()) {
            throw new VTException("invalid KYC id " + id);
        }
        return kycDataOptional.get();
    }

    public KycResponse fetchKyc(KycCheckRequest kycCheckRequest) {
        Optional<KycData> kycDataOptional = Optional.empty();
        DocType docType = kycCheckRequest.getDocType();
        if (docType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "DocType cannot be null");
        }

        switch (docType) {
            case AADHAR:
                kycDataOptional = findByAadhaar(kycCheckRequest.getData());
                break;
            case PAN:
                kycDataOptional = findByPan(kycCheckRequest.getData());
                break;
            default:
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Unsupported DocType");
        }

        if (kycDataOptional.isPresent()) {
            return new KycResponse(kycDataOptional.get());
        }
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, docType + " Not Found");
    }

    public KycResponse updateKyc(KycUpdateRequest kycUpdateRequest){
       KycData kycData = findById(kycUpdateRequest.getKycDataId());
       if(kycUpdateRequest.getDocType().equals(DocType.AADHAR)){
           kycData.setAadhaarNumber(kycUpdateRequest.getData());
       }
       if(kycUpdateRequest.getDocType().equals(DocType.PAN)){
           kycData.setPanNumber(kycUpdateRequest.getData());
       }
       kycData = kycDataRepo.save(kycData);
       return new KycResponse(kycData);
    }


    public KycResponse createKyc(KycCreateRequest kycCreateRequest) {
    Optional<KycData> existingKycData = findByPan(kycCreateRequest.getPan());
    if (existingKycData.isPresent()) {
        return new KycResponse(existingKycData.get());
    }
    KycData newKycData = new KycData();
    newKycData.setAadhaarNumber(kycCreateRequest.getAadhaar());
    newKycData.setPanNumber(kycCreateRequest.getPan());
    kycDataRepo.save(newKycData);
    return new KycResponse(newKycData);
   }



}
