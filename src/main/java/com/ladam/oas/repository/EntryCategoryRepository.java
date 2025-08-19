package com.ladam.oas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ladam.oas.model.EntryCategory;

public interface EntryCategoryRepository extends JpaRepository<EntryCategory, Long> {

}
