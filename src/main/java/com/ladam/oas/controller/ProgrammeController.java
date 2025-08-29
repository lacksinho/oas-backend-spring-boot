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

import com.ladam.oas.dto.ProgrammeDTO;
import com.ladam.oas.dto.ProgrammeRequest;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.ProgrammeService;
import com.ladam.oas.utils.ResponseBuilder;
import com.ladam.oas.utils.ResponseMessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/programmes")
@Tag(
		name = "CRUD REST APIs for Programme Resource"
)
public class ProgrammeController {

	private final ProgrammeService service;

	public ProgrammeController(ProgrammeService service) {
		this.service = service;
	}
	
	@Operation(
			summary = "Get All Programmes REST API",
			description = "Get All Programmes REST API is used to fetch all programmes fom database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping
	public ResponseEntity<ResponseDTO<List<ProgrammeDTO>>> getAllProgrammes() {

		return ResponseBuilder.build(HttpStatus.OK, service.getAllProgrammes());
	}
	
	@Operation(
			summary = "Find Programme by Id REST API",
			description = "Find Programme by Id REST API is used to get single programme from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<ProgrammeDTO>> getProgrammeById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, service.getProgrammeById(id));
	}

	@Operation(
			summary = "Add Programme REST API",
			description = "Add Programme REST API is used to save programme into database"
	)
	
	@ApiResponse(
	   responseCode = "201",
	   description = "Http Status 201 CREATED"
	)
	@PostMapping
	public ResponseEntity<ResponseDTO<ProgrammeDTO>> addProgramme(@Valid @RequestBody ProgrammeRequest request) {

		return ResponseBuilder.build(HttpStatus.CREATED, service.addProgramme(request));
	}

	@Operation(
			summary = "Update Programme REST API",
			description = "Update Programme REST API is used to update programme in database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<ProgrammeDTO>> updateProgramme(@PathVariable Long id,
			@Valid @RequestBody ProgrammeRequest request) {

		return ResponseBuilder.build(HttpStatus.OK, service.updateProgramme(id, request));
	}
	
	
	
	@Operation(
			summary = "Delete Programme REST API",
			description = "Delete Programme REST API is used to delete programme from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO<String>> deleteProgramme(@PathVariable Long id) {
		 service.deleteProgramme(id);
		return ResponseBuilder.build(HttpStatus.OK, ResponseMessage.PROGRAMME_DELETED);
	}


}
