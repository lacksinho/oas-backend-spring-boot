package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.RegionDTO;
import com.ladam.oas.dto.RegionWithDistrictsDTO;

public interface RegionService {

	List<RegionDTO> getAllRegions();

	RegionWithDistrictsDTO findRegionById(Long id);

}
