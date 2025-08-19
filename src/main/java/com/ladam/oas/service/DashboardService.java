package com.ladam.oas.service;

public interface DashboardService {

    Long getApplicantsCount();

    Long getSubmittedCount();

    Long getUnsubmittedCount();

    Long getApplicantCountByGender(String gender);

    Long getApplicantCountBySubmissionStatusAndGender(Boolean submissionStatus, String gender);
}
