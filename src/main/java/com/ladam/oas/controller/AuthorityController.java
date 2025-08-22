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

@RestController
@RequestMapping("/api/v1/authorities")
public class AuthorityController {

	private final AuthorityService authorityService;

	public AuthorityController(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	@GetMapping
	public ResponseEntity<ResponseDTO<List<AuthorityDTO>>> getAllAuthorities() {

		return ResponseBuilder.build(HttpStatus.OK, authorityService.getAllAuthorities());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<AuthorityDTO>> findAthorityById(@PathVariable Long id) {

		return ResponseBuilder.build(HttpStatus.OK, authorityService.findAuthorityById(id));
	}

}