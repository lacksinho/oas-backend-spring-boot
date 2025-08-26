package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {

	private Long id;
	private String code;
	private String shortName;
	private String name;
	private Integer categoryCode;
	private Boolean isActive = true;
}
