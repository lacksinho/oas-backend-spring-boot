package com.ladam.oas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladam.oas.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
