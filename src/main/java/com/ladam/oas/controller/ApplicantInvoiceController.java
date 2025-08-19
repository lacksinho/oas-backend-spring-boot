package com.ladam.oas.controller;

import static com.ladam.oas.utils.ResponseMessage.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ladam.oas.dto.*;
import com.ladam.oas.service.ApplicantInvoiceService;
import com.ladam.oas.service.ApplicantService;
import com.ladam.oas.utils.AppConstants;
import com.ladam.oas.utils.ResponseBuilder;


@RequestMapping("/api/v1/applicant-invoices")
@RestController
public class ApplicantInvoiceController {

    private ApplicantInvoiceService applicantInvoiceService;

    public ApplicantInvoiceController(ApplicantInvoiceService applicantInvoiceService) {
        this.applicantInvoiceService = applicantInvoiceService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<ApplicantInvoiceListDTO>> getAllApplicantInvoices(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "paid", required = false) Integer paid
    ) {
        ApplicantInvoiceListDTO applicantInvoices = applicantInvoiceService.getAllApplicantInvoices(pageNo, pageSize, sortBy, sortDir, search, paid);
        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, applicantInvoices);

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<ApplicantInvoiceDTO>> getApplicantInvoiceById(@PathVariable Long id) {
        ApplicantInvoiceDTO applicantInvoice = applicantInvoiceService.getApplicantInvoiceById(id);
        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, applicantInvoice);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplicantById(@PathVariable Long id) {
        applicantInvoiceService.deleteApplicantInvoiceById(id);
        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, null);

        return response;
    }

//    @PostMapping
//    public ResponseEntity<ResponseDTO<ApplicantDTO>> createApplicant(@RequestBody ApplicantRequest applicantRequest) {
//        ApplicantDTO applicant = applicantService.createApplicant(applicantRequest);
//        ResponseEntity response = ResponseBuilder.build(HttpStatus.CREATED, APPLICANT_CREATED, applicant);
//
//        return response;
//    }
//

//
//    @GetMapping("/index/{indexNumber}")
//    public ResponseEntity<ResponseDTO<ApplicantDTO>> getApplicantByIndexNumber(@PathVariable String indexNumber) {
//        String decodedIndexNumber = indexNumber.replace("-", "/");
//        ApplicantDTO applicant = applicantService.getApplicantByIndex(decodedIndexNumber);
//
//        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, APPLICANT_RETRIEVED, applicant);
//        return response;
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateApplicantById(@PathVariable Long id, @RequestBody ApplicantRequest applicantRequest) {
//        ApplicantDTO applicant = applicantService.updateApplicant(id, applicantRequest);
//        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, APPLICANT_UPDATE, applicant);
//
//        return response;
//    }
//
//    @PatchMapping("/{id}/submit")
//    public ResponseEntity<ResponseDTO<ApplicantDTO>> submitApplicant(@PathVariable Long id) {
//        ApplicantDTO applicant = applicantService.submitApplicant(id);
//        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, APPLICANT_SUBMITTED, applicant);
//        return response;
//    }
//
//    @PatchMapping("/{id}/unsubmit")
//    public ResponseEntity<ResponseDTO<ApplicantDTO>> unSubmitApplicant(@PathVariable Long id) {
//        ApplicantDTO applicant = applicantService.unsubmitApplicant(id);
//        ResponseEntity response = ResponseBuilder.build(HttpStatus.OK, APPLICANT_UNSUBMITTED, applicant);
//        return response;
//    }
}
