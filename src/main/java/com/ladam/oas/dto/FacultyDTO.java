package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDTO {

	private Long id;
	private String name;
	private Boolean isActive;
	private CampusSummaryDTO campus;

}
