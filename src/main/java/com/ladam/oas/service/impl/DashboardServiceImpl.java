package com.ladam.oas.service.impl;

import org.springframework.stereotype.Service;

import com.ladam.oas.repository.ApplicantRepository;
import com.ladam.oas.service.DashboardService;
import com.ladam.oas.utils.AppConstants;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final ApplicantRepository applicantRepository;

    DashboardServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public Long getApplicantsCount() {
        return applicantRepository.count();
    }

    @Override
    public Long getSubmittedCount() {
        return applicantRepository.countByIsSubmitted(AppConstants.SUBMITTED_STATUS);
    }

    @Override
    public Long getUnsubmittedCount() {
        return applicantRepository.countByIsSubmitted(AppConstants.UNSUBMITTED_STATUS);
    }

    @Override
    public Long getApplicantCountByGender(String gender) {
        return applicantRepository.countByGender(gender);
    }

    @Override
    public Long getApplicantCountBySubmissionStatusAndGender(Boolean submissionStatus, String gender) {
        return applicantRepository.countByIsSubmittedAndGender(submissionStatus,gender) ;
    }
}
