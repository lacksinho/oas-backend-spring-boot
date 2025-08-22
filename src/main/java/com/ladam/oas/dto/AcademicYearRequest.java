package com.ladam.oas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AcademicYearRequest {

	@NotEmpty(message = "Year is required")
	@Size(min = 9, max = 9, message = "Year must be exactly 9 characters")
	@Pattern(regexp = "\\d{4}/\\d{4}", message = "Year must be in format YYYY/YYYY")
	private String year;

	private Boolean isActive = false;

}
