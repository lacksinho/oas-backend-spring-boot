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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/nta-levels")
public class NtaLevelController {

	private final NtaLevelService ntaLevelService;

	public NtaLevelController(NtaLevelService ntaLevelService) {
		this.ntaLevelService = ntaLevelService;
	}

	@GetMapping
	public ResponseEntity<ResponseDTO<List<NtaLevelDTO>>> getAllNtaLevels() {

		return ResponseBuilder.build(HttpStatus.OK, ntaLevelService.getAllNtaLevels());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<NtaLevelDTO>> findNtaLevelById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, ntaLevelService.findNtaLevelById(id));
	}

	@PostMapping
	public ResponseEntity<ResponseDTO<NtaLevelDTO>> addNtaLevel(@Valid @RequestBody NtaLevelRequest request) {

		return ResponseBuilder.build(HttpStatus.CREATED, ntaLevelService.addNtaLevel(request));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<NtaLevelDTO>> updateNtaLevel(@PathVariable Long id,
			@Valid @RequestBody NtaLevelRequest request) {

		return ResponseBuilder.build(HttpStatus.OK, ntaLevelService.updateNtaLevel(id, request));
	}

}
