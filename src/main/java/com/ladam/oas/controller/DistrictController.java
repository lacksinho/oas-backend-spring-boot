package com.ladam.oas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.dto.DistrictDTO;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.DistrictService;
import com.ladam.oas.utils.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/districts")
@Tag(
		  name = "CRUD REST APIs for District Resource"		
		)
public class DistrictController {

	private final DistrictService districtService;

	public DistrictController(DistrictService districtService) {
		this.districtService = districtService;
	}
	
	@Operation(
			summary = "Get All Districts REST API",
			description = "Get All Districts REST API is used to fetch all districts from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping
	public ResponseEntity<ResponseDTO<List<DistrictDTO>>> getAllDistricts() {
		return ResponseBuilder.build(HttpStatus.OK, districtService.getAllDistricts());
	}
	
	
	@Operation(
			summary = "Get District By Id REST API",
			description = "Get District By Id REST API is used to fetch single district from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<DistrictDTO>> getDistrictById(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, districtService.getDistrictById(id));
	}

}
