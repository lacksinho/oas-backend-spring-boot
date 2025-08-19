package com.ladam.oas.service;

import com.ladam.oas.dto.ApplicantDTO;
import com.ladam.oas.dto.ApplicantListDTO;
import com.ladam.oas.dto.ApplicantRequest;

public interface ApplicantService {

    ApplicantDTO getApplicantById(Long id);

    ApplicantDTO getApplicantByIndex(String indexNumber);

    void deleteApplicantById(Long id);

    ApplicantDTO createApplicant(ApplicantRequest applicantRequest);

    ApplicantDTO updateApplicant(Long applicantId, ApplicantRequest applicantRequest);

    ApplicantDTO submitApplicant(Long applicantId);

    ApplicantDTO unsubmitApplicant(Long applicantId);

    ApplicantListDTO getAllApplicants(int pageNo, int pageSize, String sortBy, String sortDir,String search, Boolean submitted);
}
