package com.ladam.oas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladam.oas.dto.ApplicationTypeDTO;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.ApplicationTypeService;
import com.ladam.oas.utils.ResponseBuilder;

@RestController
@RequestMapping("/api/v1/application-types")
public class ApplicationTypeController {

	private final ApplicationTypeService applicationTypeService;

	public ApplicationTypeController(ApplicationTypeService applicationTypeService) {
		this.applicationTypeService = applicationTypeService;
	}

	@GetMapping
	public ResponseEntity<ResponseDTO<List<ApplicationTypeDTO>>> getAllApplicationTypes() {
		return ResponseBuilder.build(HttpStatus.OK, applicationTypeService.getAllApplicationTypes());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<ApplicationTypeDTO>> findApplicationTypeById(@PathVariable Long id) {
		return ResponseBuilder.build(HttpStatus.OK, applicationTypeService.findApplicationTypeById(id));
	}
}
