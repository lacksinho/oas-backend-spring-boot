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
public class FacultyRequest {

	@NotEmpty(message = "Name is required")
	private String name;

	private Boolean isActive = true;

	@NotNull(message = "Campus is required")
	@Positive(message = "Campus ID must be a positive number")
	private Long campusId;

}
