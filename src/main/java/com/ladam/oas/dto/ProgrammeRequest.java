package com.ladam.oas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammeRequest {

	@NotEmpty(message = "Code is required")
	@Size(min = 3, max = 10, message = "Code length must be between 3 and 10")
	private String code;

	@NotEmpty(message = "Short name is required")
	@Size(min = 3, max = 50, message = "Short name length must be between 3 and 50")
	private String shortName;

	@NotEmpty(message = "Title is required")
	private String title;

	private String alternativeTitle;

	@NotNull(message = "Duration is required")
	@Positive(message = "Duration must be a positive number")
	private Integer duration;

	@NotEmpty(message = "Authority code is required")
	private String authorityCode;

	private Boolean isActive = true;

	private Boolean isOpen = true;

	@NotNull(message = "Faculty is required")
	@Positive(message = "Faculty must be a positive number")
	private Long facultyId;

	@NotNull(message = "Campus is required")
	@Positive(message = "Campus must be a positive number")
	private Long campusId;

	@NotNull(message = "Nta level is required")
	@Positive(message = "Nta level must be a positive number")
	private Long ntaLevelId;

	@NotNull(message = "Authority is required")
	@Positive(message = "Authority must be a positive number")
	private Long authorityId;

	@NotNull(message = "Application type is required")
	@Positive(message = "Application type must be a positive number")
	private Long applicationTypeId;

}
