package com.ladam.oas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {

	@NotEmpty(message = "Code is required")
	private String code;

	@NotEmpty(message = "Short name is required")
	private String shortName;

	@NotEmpty(message = "Name is required")
	private String name;

	@NotNull(message = "Category is required")
	@Positive(message = "Category must be a positive number")
	private Integer categoryCode;

	private Boolean isActive = true;
}
