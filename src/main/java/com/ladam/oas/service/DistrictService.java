package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.DistrictDTO;

public interface DistrictService {

	List<DistrictDTO> getAllDistricts();
	
	DistrictDTO findDistrictById(Long id);
}
