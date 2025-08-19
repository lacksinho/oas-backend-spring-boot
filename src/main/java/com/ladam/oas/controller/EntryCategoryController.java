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

@RestController
@RequestMapping("/api/v1/entry-categories")
public class EntryCategoryController {

	private final EntryCategoryService entryCategoryService;

	public EntryCategoryController(EntryCategoryService entryCategoryService) {
		this.entryCategoryService = entryCategoryService;
	}

	@GetMapping
	public ResponseEntity<ResponseDTO<List<EntryCategoryDTO>>> getAllEntryCategories() {

		return ResponseBuilder.build(HttpStatus.OK, entryCategoryService.getAllEntryCategories());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<EntryCategoryDTO>> findEntryCategoryById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, entryCategoryService.findEntryCategoryById(id));
	}

}
