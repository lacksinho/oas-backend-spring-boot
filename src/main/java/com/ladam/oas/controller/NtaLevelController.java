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

import com.ladam.oas.dto.NtaLevelDTO;
import com.ladam.oas.dto.NtaLevelRequest;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.NtaLevelService;
import com.ladam.oas.utils.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/nta-levels")
@Tag(name = "CRUD REST APIs for Nta Level Resource")
public class NtaLevelController {

	private final NtaLevelService ntaLevelService;

	public NtaLevelController(NtaLevelService ntaLevelService) {
		this.ntaLevelService = ntaLevelService;
	}
	
	@Operation(
			summary = "Get All Nta Levels REST API",
			description = "Get All Nta Levels REST API is used to get all Nta Lavels from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping
	public ResponseEntity<ResponseDTO<List<NtaLevelDTO>>> getAllNtaLevels() {

		return ResponseBuilder.build(HttpStatus.OK, ntaLevelService.getAllNtaLevels());
	}
	
	@Operation(
			summary = "Find Nta Level by Id REST API",
			description = "Find Nta Level by Id REST API is used to get single Nta Lavel from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<NtaLevelDTO>> findNtaLevelById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, ntaLevelService.findNtaLevelById(id));
	}

	@Operation(
			summary = "Add Nta Level REST API",
			description = "Add Nta Level REST API is used to save post into database"
	)
	
	@ApiResponse(
	   responseCode = "201",
	   description = "Http Status 201 CREATED"
	)
	@PostMapping
	public ResponseEntity<ResponseDTO<NtaLevelDTO>> addNtaLevel(@Valid @RequestBody NtaLevelRequest request) {

		return ResponseBuilder.build(HttpStatus.CREATED, ntaLevelService.addNtaLevel(request));
	}

	@Operation(
			summary = "Update Nta Level REST API",
			description = "Update Nta Level REST API is used to update post in database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<NtaLevelDTO>> updateNtaLevel(@PathVariable Long id,
			@Valid @RequestBody NtaLevelRequest request) {

		return ResponseBuilder.build(HttpStatus.OK, ntaLevelService.updateNtaLevel(id, request));
	}

}
