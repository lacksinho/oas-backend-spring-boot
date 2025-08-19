package com.ladam.oas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ladam.oas.dto.ApplicantDTO;
import com.ladam.oas.dto.ApplicantListDTO;
import com.ladam.oas.dto.ApplicantRequest;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.ApplicantService;
import com.ladam.oas.utils.AppConstants;
import com.ladam.oas.utils.ResponseBuilder;

@CrossOrigin(origins = "https://192.168.100.18:8443")
@RequestMapping("/api/v1/applicants")
@RestController
public class ApplicantController {

    private ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<ApplicantListDTO>> getAllApplicants(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "submitted",required = false) Boolean submitted
    ) {
        ApplicantListDTO applicant = applicantService.getAllApplicants(pageNo, pageSize, sortBy, sortDir,  search, submitted);
   
        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, applicant);

        return response;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<ApplicantDTO>> createApplicant(@RequestBody ApplicantRequest applicantRequest) {
        ApplicantDTO applicant = applicantService.createApplicant(applicantRequest);
        ResponseEntity response = ResponseBuilder.build(HttpStatus.CREATED, applicant);

        return response;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseDTO<ApplicantDTO>> getApplicantById(@PathVariable Long id) {
        ApplicantDTO applicant = applicantService.getApplicantById(id);
        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, applicant);
        return response;
    }

    @GetMapping("/index/{indexNumber}")
    public ResponseEntity<ResponseDTO<ApplicantDTO>> getApplicantByIndexNumber(@PathVariable String indexNumber) {
        String decodedIndexNumber = indexNumber.replace("-", "/");
        ApplicantDTO applicant = applicantService.getApplicantByIndex(decodedIndexNumber);

        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, applicant);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplicantById(@PathVariable Long id) {
        applicantService.deleteApplicantById(id);
        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, null);

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateApplicantById(@PathVariable Long id, @RequestBody ApplicantRequest applicantRequest) {
        ApplicantDTO applicant = applicantService.updateApplicant(id, applicantRequest);
        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, applicant);

        return response;
    }

    @PatchMapping("/{id}/submit")
    public ResponseEntity<ResponseDTO<ApplicantDTO>> submitApplicant(@PathVariable Long id) {
        ApplicantDTO applicant = applicantService.submitApplicant(id);
        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, applicant);
        return response;
    }

    @PatchMapping("/{id}/unsubmit")
    public ResponseEntity<ResponseDTO<ApplicantDTO>> unSubmitApplicant(@PathVariable Long id) {
        ApplicantDTO applicant = applicantService.unsubmitApplicant(id);
        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, applicant);
        return response;
    }
}
