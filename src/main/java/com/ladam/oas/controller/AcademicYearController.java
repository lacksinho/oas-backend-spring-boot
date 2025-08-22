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

import com.ladam.oas.dto.AcademicYearDTO;
import com.ladam.oas.dto.AcademicYearRequest;
import com.ladam.oas.dto.ResponseDTO;
import com.ladam.oas.service.AcademicYearService;
import com.ladam.oas.utils.ResponseBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/academic-years")
public class AcademicYearController {

	private final AcademicYearService academicYearService;

	public AcademicYearController(AcademicYearService academicYearService) {
		this.academicYearService = academicYearService;
	}

	@PostMapping
	public ResponseEntity<ResponseDTO<AcademicYearDTO>> addAcademicYear(
			@Valid @RequestBody AcademicYearRequest academicYearRequest) {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.addAcademicYear(academicYearRequest));
	}

	@GetMapping
	public ResponseEntity<ResponseDTO<List<AcademicYearDTO>>> getAllAcademicYears() {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.getAllAcademicYears());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<AcademicYearDTO>> findAcademicYearById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.findAcademicYearById(id));
	}

	@GetMapping("/active")
	public ResponseEntity<ResponseDTO<AcademicYearDTO>> getActiveAcademicYear() {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.getActiveAcademicYear());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO<AcademicYearDTO>> updateAcademicYear(@PathVariable Long id,
			@Valid @RequestBody AcademicYearRequest academicYearRequest) {

		return ResponseBuilder.build(HttpStatus.OK, academicYearService.updateAcademicYear(id,academicYearRequest));
	}

}