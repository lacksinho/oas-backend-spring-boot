package com.ladam.oas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.dto.ApplicationTypeDTO;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.ApplicationTypeService;
import com.ladam.oas.utils.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/application-types")
@Tag(
		  name = "CRUD REST APIs for Application Type Resource"		
				
		)
public class ApplicationTypeController {

	private final ApplicationTypeService applicationTypeService;

	public ApplicationTypeController(ApplicationTypeService applicationTypeService) {
		this.applicationTypeService = applicationTypeService;
	}
	
	
	@Operation(
			summary = "Get All  Application Types REST API",
			description = "Get All  Application Types REST API is used to fetch all application types from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping
	public ResponseEntity<ResponseDTO<List<ApplicationTypeDTO>>> getAllApplicationTypes() {
		return ResponseBuilder.build(HttpStatus.OK, applicationTypeService.getAllApplicationTypes());
	}
	
	
	@Operation(
			summary = "Get Application Type by Id REST API",
			description = "Get Application Type by Id REST API is used to get single application type from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<ApplicationTypeDTO>> getApplicationTypeById(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, applicationTypeService.getApplicationTypeById(id));
	}
}
