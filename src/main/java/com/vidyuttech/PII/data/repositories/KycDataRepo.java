package com.vidyuttech.PII.data.repositories;


import com.vidyuttech.PII.data.entities.KycData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KycDataRepo extends CrudRepository<KycData, Long> {

    Optional<KycData> findByPanNumber(String panNumber);

    Optional<KycData> findByAadhaarNumber(String aadhaarNumber);
}
