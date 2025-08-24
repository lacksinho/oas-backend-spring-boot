package com.ladam.oas.model;

import java.time.LocalDateTime;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "programmes")
@EntityListeners(AuditingEntityListener.class)
public class Programme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String code;

	@Column(name = "short_name", nullable = false, unique = true)
	private String shortName;

	private String title;

	@Column(name = "alternative_title")
	private String alternativeTitle;

	@Column(nullable = false)
	private Integer duration;

	@Column(name = "authority_code")
	private String authorityCode;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive = true;

	@Column(name = "is_open", nullable = false)
	private Boolean isOpen = true;

	@ManyToOne
	@JoinColumn(name = "faculty_id")
	private Faculty faculty;

	@ManyToOne
	@JoinColumn(name = "campus_id")
	private Campus campus;

	@ManyToOne
	@JoinColumn(name = "nta_level_id")
	private NtaLevel ntaLevel;

	@ManyToOne
	@JoinColumn(name = "authority_id")
	private Authority authority;

	@ManyToOne
	@JoinColumn(name = "application_type_id")
	private ApplicationType applicationType;

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
