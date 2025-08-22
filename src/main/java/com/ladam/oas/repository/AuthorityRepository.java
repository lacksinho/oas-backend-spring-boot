package com.ladam.oas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladam.oas.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
