package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ladam.oas.dto.RegionDTO;
import com.ladam.oas.dto.RegionWithDistrictsDTO;
import com.ladam.oas.mapper.RegionMapper;
import com.ladam.oas.model.Region;
import com.ladam.oas.repository.RegionRepository;
import com.ladam.oas.service.RegionService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class RegionServiceImpl implements RegionService {

	private final EntityHelperService entityHelperService;
	private final RegionRepository regionRepository;
	private final RegionMapper regionMapper;

	public RegionServiceImpl(EntityHelperService entityHelperService, RegionRepository regionRepository,
			RegionMapper regionMapper) {
		this.entityHelperService = entityHelperService;
		this.regionRepository = regionRepository;
		this.regionMapper = regionMapper;

	}

	@Cacheable
	@Override
	public List<RegionDTO> getAllRegions() {
		return entityHelperService.mapList(regionRepository.findAll(), regionMapper::toDTO);
	}

	@Override
	public RegionWithDistrictsDTO findRegionById(Long id) {
		Region region = entityHelperService.getByIdOrThrow(regionRepository, id, "Region");
		return regionMapper.toRegionWithDistrictsDTO(region);
	}
}
