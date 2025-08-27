package com.ladam.oas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.dto.ApplicantDTO;
import com.ladam.oas.dto.ApplicantListDTO;
import com.ladam.oas.dto.ApplicantRequest;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.ApplicantService;
import com.ladam.oas.utils.AppConstants;
import com.ladam.oas.utils.ResponseBuilder;
import com.ladam.oas.utils.ResponseMessage;

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
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
			@RequestParam(required = false) String search, @RequestParam(required = false) Boolean submitted) {

		return ResponseBuilder.build(HttpStatus.OK,
				applicantService.getAllApplicants(pageNo, pageSize, sortBy, sortDir, search, submitted));
	}

	@PostMapping
	public ResponseEntity<ResponseDTO<ApplicantDTO>> createApplicant(@RequestBody ApplicantRequest applicantRequest) {
		return ResponseBuilder.build(HttpStatus.CREATED, applicantService.createApplicant(applicantRequest));

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> getApplicantById(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, applicantService.getApplicantById(id));
	}

	@GetMapping("/index/{indexNumber}")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> getApplicantByIndexNumber(@PathVariable String indexNumber) {
		return ResponseBuilder.build(HttpStatus.OK, applicantService.getApplicantByIndex(indexNumber));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO<String>> deleteApplicantById(@PathVariable Long id) {
		applicantService.deleteApplicantById(id);
		return ResponseBuilder.build(HttpStatus.OK, ResponseMessage.APPLICANT_DELETE);

	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> updateApplicantById(@PathVariable Long id,
			@RequestBody ApplicantRequest applicantRequest) {
		return ResponseBuilder.build(HttpStatus.OK, applicantService.updateApplicant(id, applicantRequest));
	}

	@PatchMapping("/{id}/submit")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> submitApplicant(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, applicantService.submitApplicant(id));
	}

	@PatchMapping("/{id}/unsubmit")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> unSubmitApplicant(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, applicantService.unsubmitApplicant(id));
	}
}
