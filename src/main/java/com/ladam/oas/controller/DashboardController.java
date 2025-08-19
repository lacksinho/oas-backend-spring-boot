package com.ladam.oas.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.service.DashboardService;
import com.ladam.oas.utils.AppConstants;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/summary")
    public Map<String, Long> getApplicantSummary() {
        long totalApplicants = dashboardService.getApplicantsCount();
        long submittedApplicants = dashboardService.getSubmittedCount();
        long unsubmittedApplicants = dashboardService.getUnsubmittedCount();

        long maleCount = dashboardService.getApplicantCountByGender("M");
        long femaleCount = dashboardService.getApplicantCountByGender("F");

        Long submittedMaleCount = dashboardService.getApplicantCountBySubmissionStatusAndGender(AppConstants.SUBMITTED_STATUS,"M");
        Long submittedFemaleCount = dashboardService.getApplicantCountBySubmissionStatusAndGender(AppConstants.SUBMITTED_STATUS,"F");

        Map<String, Long> summary = new LinkedHashMap<>();
        summary.put("total", totalApplicants);
        summary.put("male", maleCount);
        summary.put("female", femaleCount);
        summary.put("submitted", submittedApplicants);
        summary.put("unsubmitted", unsubmittedApplicants);
        summary.put("submittedMale", submittedMaleCount);
        summary.put("submittedFemale", submittedFemaleCount);

        return summary;
    }
}
