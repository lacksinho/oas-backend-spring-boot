package com.ladam.oas.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Schema(
	description = "NtaLevelRequest model information"
)
public class NtaLevelRequest {

	@Schema(description = "Nta Level")
	@NotEmpty(message = "Level is required")
	@Size(min = 3, message = "The minimum characters is 3")
	private String level;
	@Schema(description = "Nta Level status")
	private Boolean isActive=true;

}
