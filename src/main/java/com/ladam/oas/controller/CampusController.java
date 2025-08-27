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

import com.ladam.oas.dto.CampusDTO;
import com.ladam.oas.dto.CampusRequest;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.CampusService;
import com.ladam.oas.utils.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/campuses")
@Tag(
  name = "CRUD REST APIs for Campus Resource"		
		
)
public class CampusController {

	private final CampusService campusService;

	public CampusController(CampusService campusService) {
		this.campusService = campusService;
	}

	
	@Operation(
			summary = "Get All Campuses REST API",
			description = "Get All Campuses REST API is used to fetch all campuses from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@GetMapping
	public ResponseEntity<ResponseDTO<List<CampusDTO>>> getAllCampuses() {

		return ResponseBuilder.build(HttpStatus.OK, campusService.getAllCampuses());
	}
	
	
	@Operation(
			summary = "Get Campus By Id REST API",
			description = "Get Campus By Id REST API is used to fetch single campus from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)


	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<CampusDTO>> getCampusById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, campusService.getCampusById(id));
	}
	
	
	@Operation(
			summary = "Add Campus REST API",
			description = "Add Campus REST API is used to save campus into database"
	)
	
	@ApiResponse(
	   responseCode = "201",
	   description = "Http Status 201 CREATED"
	)

	@PostMapping
	public ResponseEntity<ResponseDTO<CampusDTO>> addCampus(@Valid @RequestBody CampusRequest campusRequest) {

		return ResponseBuilder.build(HttpStatus.CREATED, campusService.addCampus(campusRequest));
	}
	
	
	@Operation(
			summary = "Update Campus REST API",
			description = "Update Campus REST API is used to save campus into database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 CREATED"
	)

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<CampusDTO>> updateCampus(@PathVariable Long id,
			@Valid @RequestBody CampusRequest campusRequest) {

		return ResponseBuilder.build(HttpStatus.OK, campusService.updateCampus(id,campusRequest));
	}

}