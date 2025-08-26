package com.ladam.oas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.dto.FacultyDTO;
import com.ladam.oas.dto.FacultyRequest;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.dto.SubjectDTO;
import com.ladam.oas.dto.SubjectRequest;
import com.ladam.oas.service.FacultyService;
import com.ladam.oas.service.SubjectService;
import com.ladam.oas.utils.ResponseBuilder;
import com.ladam.oas.utils.ResponseMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/subjects")
@Tag(name = "CRUD REST APIs for Subject Resource")
public class SubjectController {

	private final SubjectService service;

	public SubjectController(SubjectService service) {
		this.service = service;
	}
	
	@Operation(
			summary = "Get All Subjects REST API",
			description = "Get All Subjects REST API is used to fetch all subjecties fom database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping
	public ResponseEntity<ResponseDTO<List<SubjectDTO>>> getAllSubjecties() {

		return ResponseBuilder.build(HttpStatus.OK, service.getAllSubjects());
	}
	
	
	
	@Operation(
			summary = "Find Subject by Id REST API",
			description = "Find Subject by Id REST API is used to get single subject from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<SubjectDTO>> findSubjectById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, service.findSubjectById(id));
	}
	
	

	@Operation(
			summary = "Add Subject REST API",
			description = "Add Subject REST API is used to save subject into database"
	)
	
	@ApiResponse(
	   responseCode = "201",
	   description = "Http Status 201 CREATED"
	)
	@PostMapping
	public ResponseEntity<ResponseDTO<SubjectDTO>> addSubject(@Valid @RequestBody SubjectRequest request) {

		return ResponseBuilder.build(HttpStatus.CREATED, service.addSubject(request));
	}

	@Operation(
			summary = "Update Subject REST API",
			description = "Update Subject REST API is used to update subject in database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<SubjectDTO>> updateSubject(@PathVariable Long id,
			@Valid @RequestBody SubjectRequest request) {

		return ResponseBuilder.build(HttpStatus.OK, service.updateSubject(id, request));
	}
	
	
	
	
	@Operation(
			summary = "Delete Subject REST API",
			description = "Delete Subject REST API is used to delete subject from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO<String>> deleteSubject(@PathVariable Long id) {
		 service.deleteSubject(id);
		return ResponseBuilder.build(HttpStatus.OK, ResponseMessage.SUBJECT_DELETED);
	}


}
