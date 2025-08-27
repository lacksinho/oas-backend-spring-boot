package com.ladam.oas.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.ladam.oas.dto.EntryCategoryDTO;

public interface EntryCategoryService {
	
	@Cacheable
	List<EntryCategoryDTO> getAllEntryCategories();
	EntryCategoryDTO getEntryCategoryById(Long id);

}
