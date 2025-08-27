package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ladam.oas.dto.DistrictDTO;
import com.ladam.oas.mapper.DistrictMapper;
import com.ladam.oas.model.District;
import com.ladam.oas.repository.DistrictRepository;
import com.ladam.oas.service.DistrictService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class DistrictServiceImpl implements DistrictService {

	private final EntityHelperService entityHelperService;
	private DistrictRepository districtRepository;
	private DistrictMapper districtMapper;

	public DistrictServiceImpl(EntityHelperService entityHelperService, DistrictRepository districtRepository,
			DistrictMapper districtMapper) {
		this.entityHelperService = entityHelperService;
		this.districtRepository = districtRepository;
		this.districtMapper = districtMapper;

	}

	@Cacheable
	@Override
	public List<DistrictDTO> getAllDistricts() {
		return entityHelperService.mapList(districtRepository.findAll(), districtMapper::toDTO);
	}

	@Override
	public DistrictDTO getDistrictById(Long id) {
		District district = entityHelperService.getByIdOrThrow(districtRepository, id, "District");
		return districtMapper.toDTO(district);
	}
}
