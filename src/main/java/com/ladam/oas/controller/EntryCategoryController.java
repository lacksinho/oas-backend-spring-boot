package com.ladam.oas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.dto.EntryCategoryDTO;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.EntryCategoryService;
import com.ladam.oas.utils.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/entry-categories")
@Tag(
		  name = "CRUD REST APIs for Entry Category Resource"		
		)
public class EntryCategoryController {

	private final EntryCategoryService entryCategoryService;

	public EntryCategoryController(EntryCategoryService entryCategoryService) {
		this.entryCategoryService = entryCategoryService;
	}
	
	@Operation(
			summary = "Get All Entry Categories REST API",
			description = "Get All Entry Categories REST API is used to fetch all entry categories from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	

	@GetMapping
	public ResponseEntity<ResponseDTO<List<EntryCategoryDTO>>> getAllEntryCategories() {

		return ResponseBuilder.build(HttpStatus.OK, entryCategoryService.getAllEntryCategories());
	}

	
	@Operation(
			summary = "Get Entry Category By Id REST API",
			description = "Get Entry Category By Id REST API is used to fetch single entry category from database"
	)
	
	@ApiResponse(
	   responseCode = "200",
	   description = "Http Status 200 SUCCESS"
	)
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<EntryCategoryDTO>> getEntryCategoryById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, entryCategoryService.getEntryCategoryById(id));
	}

}
