package com.ladam.oas.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantRequest {

	@NotNull(message = "Category is required")
	@Positive(message = "Category must be a positive number")
	private Long entryCategoryId;

	@NotNull(message = "Application type is required")
	@Positive(message = "Application type must be a positive number")
	private Long applicationTypeId;

	@NotEmpty(message = "First name is required")
	private String firstName;

	private String middleName;

	@NotEmpty(message = "Last name is required")
	private String lastName;

	@NotEmpty(message = "Gender is required")
	@Pattern(regexp = "F|M", message = "Gender must be F or M")
	private String gender;

	@NotNull(message = "Marital status is required")
	@Positive(message = "Marital status must be a positive number")
	private Integer maritalStatusId;

	@NotNull(message = "Date is required")
	@Past(message = "Birth date must be in the past")
	private LocalDate birthDate;

	private String birthPlace;

	@NotNull(message = "Disability is required")
	@Positive(message = "Disability must be a positive number")
	private Long disabilityId;

	private Boolean isEmployed = false;

	@NotEmpty(message = "Form index number is required")
	@Pattern(
		    regexp = "(S|P)\\d{4}-\\d{4}-\\d{4}|EQ\\d{10}/\\d{4}",
		    message = "Form index number must be like SXXXX-XXXX-YYYY, PXXXX-XXXX-YYYY, or EQYYYYXXXXXX/YYYY"
		)
	private String formFourIndex;

	@Email(message = "Email must be in valid format")
	private String email;

	@NotEmpty(message = "Mobile number is required")
	private String mobileNumber;

	private String postalAddress;

	private String physicalAddress;

	@NotNull(message = "Nationality is required")
	@Positive(message = "Nationality must be a positive number")
	private Long nationalityId;

	@NotNull(message = "Region is required")
	@Positive(message = "Region must be a positive number")
	private Long regionId;

	@NotNull(message = "District is required")
	@Positive(message = "District must be a positive number")
	private Long districtId;

}
