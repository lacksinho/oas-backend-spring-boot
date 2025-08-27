package com.ladam.oas.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "short_code", nullable = false, unique = true)
	private String shortCode;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false, unique = true)
	private String nationality;

	@Column(name = "is_active")
	private Boolean isActive = true;

	@OneToMany(mappedBy = "nationality", cascade = CascadeType.ALL)
	private List<Applicant> applicants;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	@Column(name = "deleted_at")
	private LocalDate deteledAt;

}
