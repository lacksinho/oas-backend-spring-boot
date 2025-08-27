package com.ladam.oas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.dto.AcademicYearDTO;
import com.ladam.oas.dto.AcademicYearRequest;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.AcademicYearService;
import com.ladam.oas.utils.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/academic-years")
@Tag(
		  name = "CRUD REST APIs for Academic Year Resource"		
				
		)
public class AcademicYearController {

	private final AcademicYearService academicYearService;

	public AcademicYearController(AcademicYearService academicYearService) {
		this.academicYearService = academicYearService;
	}
	
	
	@Operation(
			summary = "Add Academic Year REST API",
			description = "Add Academic Year REST API is used to save accademic year into database"
	)
	
	@ApiResponse(
	   responseCode = "201",
	   description = "Http Status 201 CREATED"
	)

	@PostMapping
	public ResponseEntity<ResponseDTO<AcademicYearDTO>> addAcademicYear(
			@Valid @RequestBody AcademicYearRequest academicYearRequest) {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.addAcademicYear(academicYearRequest));
	}

	
	@Operation(
			summary = "Get All Academic Years REST API",
			description = "Get All Academic Years REST API is used to fetch all academic years from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<AcademicYearDTO>>> getAllAcademicYears() {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.getAllAcademicYears());
	}
	
	
	@Operation(
			summary = "Get Academic Year by Id REST API",
			description = "Get Academic Year by Id REST API is used to get single academic year from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<AcademicYearDTO>> getAcademicYearById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.getAcademicYearById(id));
	}
	
	
	@Operation(
			summary = "Get Active Academic Year REST API",
			description = "Get Academic Year REST API is used to get single active academic year from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping("/active")
	public ResponseEntity<ResponseDTO<AcademicYearDTO>> getActiveAcademicYear() {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.getActiveAcademicYear());
	}
	
	
	@Operation(
			summary = "Update Academic Year REST API",
			description = "Update Academic Year REST API is used to update accademic year into database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<AcademicYearDTO>> updateAcademicYear(@PathVariable Long id,
			@Valid @RequestBody AcademicYearRequest academicYearRequest) {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.updateAcademicYear(id,academicYearRequest));
	}

}