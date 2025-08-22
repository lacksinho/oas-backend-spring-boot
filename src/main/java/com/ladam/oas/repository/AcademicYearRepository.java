package com.ladam.oas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladam.oas.model.AcademicYear;

public interface AcademicYearRepository extends JpaRepository<AcademicYear, Long> {

	Optional<AcademicYear> findByIsActiveTrue();

	Boolean existsByYear(String year);
	
	Long countByIsActiveTrue();
}
