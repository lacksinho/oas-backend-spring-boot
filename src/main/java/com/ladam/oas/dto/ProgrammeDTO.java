package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammeDTO {
	
	private Long id;
	private String code;
	private String shortName;
	private String title;
	private String alternativeTitle;
	private Integer duration;
	private String authorityCode;
	private Boolean isActive;
	private Boolean isOpen;
	private FacultyDTO faculty;
	private CampusDTO campus;
	private NtaLevelDTO ntaLevel;
	private AuthorityDTO authority;
	private ApplicationTypeDTO applicationType;


}
