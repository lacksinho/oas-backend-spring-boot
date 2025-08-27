package com.ladam.oas.model;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "applicants")
@EntityListeners(AuditingEntityListener.class)
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "applicant_number", nullable = false, unique = true)
	private String applicantNumber;

	@ManyToOne
	@JoinColumn(name = "entry_category_id")
	private EntryCategory entryCategory;

	@ManyToOne
	@JoinColumn(name = "application_type_id")
	private ApplicationType applicationType;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String gender;

	@Column(name = "marital_status", nullable = false)
	private Integer maritalStatusId;

	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@Column(name = "birth_place")
	private String birthPlace;

	@ManyToOne
	@JoinColumn(name = "disability_id")
	private Disability disability;

	@Column(name = "is_employed")
	private Boolean isEmployed = false;

	@Column(name = "form_four_index", nullable = false, unique = true)
	private String formFourIndex;

	@Column(name = "fee_discount")
	private Double feeDiscount;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "postal_address")
	private String postalAddress;

	@Column(name = "physical_address")
	private String physicalAddress;

	@ManyToOne
	@JoinColumn(name = "nationality_id")
	private Country nationality;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;

	@Column(name = "has_tcu_status_checked")
	private Boolean hasTcuStatusChecked = false;

	@Column(name = "is_submitted", nullable = false)
	private Boolean isSubmitted = false;

	@Column(name = "submitted_on")
	private LocalDate submittedOn;

	@Column(name = "is_confirmed")
	private Boolean isConfirmed = false;

	@Column(name = "has_imported")
	private Boolean hasImported = false;

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDate createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private LocalDate updatedAt;

}
