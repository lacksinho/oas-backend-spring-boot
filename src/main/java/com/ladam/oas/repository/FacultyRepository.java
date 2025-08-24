package com.ladam.oas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladam.oas.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
