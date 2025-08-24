package com.ladam.oas.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NtaLevelRequest {

	@NotEmpty(message = "Level is required")
	private String level;
	private Boolean isActive=true;

}
