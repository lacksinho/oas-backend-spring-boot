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

@RestController
@RequestMapping("/api/v1/districts")
public class DistrictController {

	private final DistrictService districtService;

	public DistrictController(DistrictService districtService) {
		this.districtService = districtService;
	}

	@GetMapping
	public ResponseEntity<ResponseDTO<List<DistrictDTO>>> getAllDistricts() {
		return ResponseBuilder.build(HttpStatus.OK, districtService.getAllDistricts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<DistrictDTO>> findDistrictById(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, districtService.findDistrictById(id));
	}

}
