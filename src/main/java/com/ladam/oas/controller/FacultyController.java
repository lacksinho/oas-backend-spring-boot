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
import com.ladam.oas.service.FacultyService;
import com.ladam.oas.utils.ResponseBuilder;
import com.ladam.oas.utils.ResponseMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/faculties")
@Tag(name = "CRUD REST APIs for Faculty Resource")
public class FacultyController {

	private final FacultyService service;

	public FacultyController(FacultyService service) {
		this.service = service;
	}
	
	@Operation(
			summary = "Get All Faculties REST API",
			description = "Get All Faculties REST API is used to fetch all faculties fom database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping
	public ResponseEntity<ResponseDTO<List<FacultyDTO>>> getAllFaculties() {

		return ResponseBuilder.build(HttpStatus.OK, service.getAllFaculties());
	}
	
	@Operation(
			summary = "Find Faculty by Id REST API",
			description = "Find Faculty by Id REST API is used to get single faculty from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<FacultyDTO>> findFacultyById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, service.findFacultyById(id));
	}

	@Operation(
			summary = "Add Faculty REST API",
			description = "Add Faculty REST API is used to save faculty into database"
	)
	
	@ApiResponse(
	   responseCode = "201",
	   description = "Http Status 201 CREATED"
	)
	@PostMapping
	public ResponseEntity<ResponseDTO<FacultyDTO>> addFaculty(@Valid @RequestBody FacultyRequest request) {

		return ResponseBuilder.build(HttpStatus.CREATED, service.addFaculty(request));
	}

	@Operation(
			summary = "Update Faculty REST API",
			description = "Update Faculty REST API is used to update faculty in database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<FacultyDTO>> updateFaculty(@PathVariable Long id,
			@Valid @RequestBody FacultyRequest request) {

		return ResponseBuilder.build(HttpStatus.OK, service.updateFaculty(id, request));
	}
	
	@Operation(
			summary = "Delete Faculty REST API",
			description = "Delete Faculty REST API is used to delete faculty from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO<String>> deleteFaculty(@PathVariable Long id) {
		 service.deleteFaculty(id);
		return ResponseBuilder.build(HttpStatus.OK, ResponseMessage.FACULTY_DELETED);
	}


}
