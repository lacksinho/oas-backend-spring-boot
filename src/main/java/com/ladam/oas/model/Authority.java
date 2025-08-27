package com.ladam.oas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "authorities")
public class Authority implements Activatable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;

	@Column(name = "is_active")
	private Boolean isActive = false;

	@Override
	public Boolean getIsActive() {
		return isActive;
	}

	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	@Column(name = "deleted_at")
	private LocalDate deteledAt;

}
