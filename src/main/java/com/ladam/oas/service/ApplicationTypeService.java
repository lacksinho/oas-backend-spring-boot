package com.ladam.oas.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.ladam.oas.dto.ApplicationTypeDTO;

public interface ApplicationTypeService {
	@Cacheable
	List<ApplicationTypeDTO> getAllApplicationTypes();
	ApplicationTypeDTO findApplicationTypeById(Long id);

}
