package com.ladam.oas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladam.oas.model.Programme;

public interface ProgrammeRepository extends JpaRepository<Programme, Long> {

}
