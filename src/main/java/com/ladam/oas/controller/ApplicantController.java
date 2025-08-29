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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin(origins = "https://192.168.100.18:8443")
@RequestMapping("/api/v1/applicants")
@RestController
@Tag(
		name = "CRUD REST APIs for Applicant Resource"
)
public class ApplicantController {

	private ApplicantService service;

	public ApplicantController(ApplicantService applicantService) {
		this.service = applicantService;
	}

	
	@Operation(
			summary = "Get All Applicants REST API",
			description = "Get All Applicants REST API is used to fetch all applicants fom database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@GetMapping
	public ResponseEntity<ResponseDTO<ApplicantListDTO>> getAllApplicants(
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
			@RequestParam(required = false) String search, @RequestParam(required = false) Boolean submitted) {

		return ResponseBuilder.build(HttpStatus.OK,
				service.getAllApplicants(pageNo, pageSize, sortBy, sortDir, search, submitted));
	}
	
	
	@Operation(
			summary = "Get Applicant by Id REST API",
			description = "Get Applicant by Id REST API is used to get single applicant from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	
	@GetMapping("/id/{id}")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> getApplicantById(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, service.getApplicantById(id));
	}
	
	
	@Operation(
			summary = "Get Applicant by index number REST API",
			description = "Get Applicant by index number REST API is used to get single applicant from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)


	@GetMapping("/index/{indexNumber}")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> getApplicantByIndexNumber(@PathVariable String indexNumber) {
		return ResponseBuilder.build(HttpStatus.OK, service.getApplicantByIndex(indexNumber));
	}
	
	
	@Operation(
			summary = "Register Applicant REST API",
			description = "Register Applicant REST API is used to register applicant into database"
	)
	
	@ApiResponse(
	   responseCode = "201",
	   description = "Http Status 201 CREATED"
	)

	@PostMapping
	public ResponseEntity<ResponseDTO<ApplicantDTO>> registerApplicant(@Valid @RequestBody ApplicantRequest applicantRequest) {
		return ResponseBuilder.build(HttpStatus.CREATED, service.registerApplicant(applicantRequest));

	}
	
	
	@Operation(
			summary = "Update Applicant REST API",
			description = "Update Applicant REST API is used to update applicant into database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> updateApplicant(@PathVariable Long id,
			@Valid @RequestBody ApplicantRequest applicantRequest) {
		return ResponseBuilder.build(HttpStatus.OK, service.updateApplicant(id, applicantRequest));
	}
	
	
	@Operation(
			summary = "Delete Applicant REST API",
			description = "Delete Applicant REST API is used to delete applicant from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO<String>> deleteApplicant(@PathVariable Long id) {
		service.deleteApplicantById(id);
		return ResponseBuilder.build(HttpStatus.OK, ResponseMessage.APPLICANT_DELETE);

	}

	@Operation(
			summary = "Submit Applicant REST API",
			description = "Submit Applicant REST API is used to submit applicant in database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	

	@PatchMapping("/{id}/submit")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> submitApplicant(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, service.submitApplicant(id));
	}
	
	@Operation(
			summary = "Unsubmit Applicant REST API",
			description = "Unsubmit Applicant REST API is used to unsubmit applicant in database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	

	@PatchMapping("/{id}/unsubmit")
	public ResponseEntity<ResponseDTO<ApplicantDTO>> unSubmitApplicant(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, service.unsubmitApplicant(id));
	}
}
