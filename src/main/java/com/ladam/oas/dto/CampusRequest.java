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
public class CampusRequest {

	@NotEmpty(message = "Code is required")
	private String code;
	
	@NotEmpty(message = "Name is required")
	private String name;
	
	@NotEmpty(message = "Short name is required")
	private String shortName;

	@NotEmpty(message = "Location is required")
	private String location;
	
	private Boolean isActive = true;

}
