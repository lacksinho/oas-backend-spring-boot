package com.ladam.oas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "applicants")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(name = "AYear")
//	private String academicYear;

	@Column(name = "applicant_number")
	private String applicantNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	private String gender;

	@Column(name = "marital_status")
	private Integer maritalStatus;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "birth_place")
	private String birthPlace;

	@Column(name = "Disability")
	private Integer disability;

	@Column(name = "is_employed")
	private Boolean isEmployed;

	@Column(name = "form_four_index")
	private String formFourIndex;

	@Column(name = "fee_discount")
	private Double feeDiscount;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobileNumber;

	@Column(name = "postal_address")
	private String postalAddress;

	@Column(name = "physical_address")
	private String physicalAddress;

//	@Column(name = "Nationality")
//	private Integer nationality;

	@Column(name = "has_status_checked")
	private Boolean hasStatusChecked;

	@Column(name = "is_submitted", nullable = false)
	private Boolean isSubmitted=false;

	@Column(name = "submitted_on")
	private LocalDate submittedOn;

	@Column(name = "is_confirmed")
	private Boolean isConfirmed;

	@Column(name = "has_imported")
	private Boolean hasImported;

	@Column(name = "region_id")
	private Integer regionId;

	@Column(name = "district_id")
	private Integer districtId;
	
//	@ManyToOne
//	@JoinColumn(name = "entry_category_id")
//	private EntryCategory entryCategory;


//	@ManyToOne
//	@JoinColumn(name = "app_type")
//	private ApplicationCategory applicationCategory;
//

//	@Column(name = "app_level")
//	private Integer appLevel;
//
//	@Column(name = "app_round")
//	private Integer appRound;

}
