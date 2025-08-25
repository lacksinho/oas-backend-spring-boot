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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/campuses")
public class CampusController {

	private final CampusService campusService;

	public CampusController(CampusService campusService) {
		this.campusService = campusService;
	}

	@GetMapping
	public ResponseEntity<ResponseDTO<List<CampusDTO>>> getAllCampuses() {

		return ResponseBuilder.build(HttpStatus.OK, campusService.getAllCampuses());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<CampusDTO>> findCampusById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, campusService.findCampusById(id));
	}

	@PostMapping
	public ResponseEntity<ResponseDTO<CampusDTO>> addCampus(@Valid @RequestBody CampusRequest campusRequest) {

		return ResponseBuilder.build(HttpStatus.CREATED, campusService.addCampus(campusRequest));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<CampusDTO>> updateCampus(@PathVariable Long id,
			@Valid @RequestBody CampusRequest campusRequest) {

		return ResponseBuilder.build(HttpStatus.OK, campusService.updateCampus(id,campusRequest));
	}

}