package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
	
	private Long id;
	private String code;
	private String shortName;
	private String name;
	private String category;
	private Boolean isActive;

}
