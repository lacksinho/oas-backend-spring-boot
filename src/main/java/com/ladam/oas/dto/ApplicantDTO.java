package com.ladam.oas.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDTO {

	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private LocalDate birthDate;
	private String gender;
	private String maritalStatus;
	private String formFourIndex;
	private String email;
	private String mobileNumber;
	private Boolean submitted;
	private String entryCategory;
	private String applicationType;
	private String applicationNumber;
}
