package com.ladam.oas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladam.oas.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
