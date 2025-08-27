package com.ladam.oas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.dto.AuthorityDTO;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.AuthorityService;
import com.ladam.oas.utils.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/authorities")
@Tag(
		  name = "CRUD REST APIs for Authority Resource"		
		)
public class AuthorityController {

	private final AuthorityService authorityService;

	public AuthorityController(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
	
	@Operation(
			summary = "Get All Authorities REST API",
			description = "Get All Authorities REST API is used to fetch all authorities from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping
	public ResponseEntity<ResponseDTO<List<AuthorityDTO>>> getAllAuthorities() {

		return ResponseBuilder.build(HttpStatus.OK, authorityService.getAllAuthorities());
	}
	
	
	@Operation(
			summary = "Get Authority By Id REST API",
			description = "Get Authority By Id REST API is used to fetch single authority from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<AuthorityDTO>> getAthorityById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, authorityService.getAuthorityById(id));
	}

}