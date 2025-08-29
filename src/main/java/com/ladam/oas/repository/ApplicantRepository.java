package com.ladam.oas.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ladam.oas.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

	Optional<Applicant> getApplicantByFormFourIndex(String indexNumber);

	Page<Applicant> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrFormFourIndexContainingIgnoreCase(
			String firstName, String lastName, String indexNumber, Pageable pageable);

	Page<Applicant> findByIsSubmittedAndFirstNameContainingIgnoreCaseOrIsSubmittedAndLastNameContainingIgnoreCaseOrIsSubmittedAndFormFourIndexContainingIgnoreCase(
			Boolean submitted1, String firstName, Boolean submitted2, String lastName, Boolean submitted3,
			String indexNumber, Pageable pageable);

	long countByIsSubmitted(Boolean submitted);

	Long countByGender(String gender);

	Long countByIsSubmittedAndGender(Boolean submitted, String gender);

	Page<Applicant> findByIsSubmitted(Boolean submitted, Pageable pageable);

	boolean existsByFormFourIndex(String formFourIndex);
}
