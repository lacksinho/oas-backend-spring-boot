package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammeRequest {
	
	private String code;
	private String shortName;
	private String title;
	private String alternativeTitle;
	private Integer duration;
	private String authorityCode;
	private Boolean isActive;
	private Boolean isOpen;
	private Long facultyId;
	private Long campusId;
	private Long ntaLevelId;
	private Long authorityId;
	private Long applicationTypeId;

}
