package com.ladam.oas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.dto.RegionDTO;
import com.ladam.oas.dto.RegionWithDistrictsDTO;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.RegionService;
import com.ladam.oas.utils.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/regions")
@Tag(
		  name = "CRUD REST APIs for Region Resource"		
		)
public class RegionController {

	private final RegionService regionService;

	
	public RegionController(RegionService regionService) {
		this.regionService = regionService;
	}

	@Operation(
			summary = "Get All Regions REST API",
			description = "Get All Regions REST API is used to fetch all regions from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<RegionDTO>>> getAllRegions() {	
		return  ResponseBuilder.build(HttpStatus.OK, regionService.getAllRegions());
	}
	
	
	
	@Operation(
			summary = "Get Region By Id REST API",
			description = "Get Region By Id REST API is used to fetch single region from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<RegionWithDistrictsDTO>> getRegionById(@PathVariable Long id) {	
	return ResponseBuilder.build(HttpStatus.OK, regionService.getRegionById(id));
	}

}
