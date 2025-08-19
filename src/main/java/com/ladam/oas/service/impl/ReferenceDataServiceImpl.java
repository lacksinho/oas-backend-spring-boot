package com.ladam.oas.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ladam.oas.dto.ApplicationTypeDTO;
import com.ladam.oas.dto.EntryCategoryDTO;
import com.ladam.oas.mapper.ApplicationTypeMapper;
import com.ladam.oas.mapper.DistrictMapper;
import com.ladam.oas.mapper.EntryCategoryMapper;
import com.ladam.oas.mapper.RegionMapper;
import com.ladam.oas.repository.ApplicationTypeRepository;
import com.ladam.oas.repository.EntryCategoryRepository;
import com.ladam.oas.service.ReferenceDataService;

@Service
public class ReferenceDataServiceImpl implements ReferenceDataService {

	private final EntryCategoryRepository entryCategoryRepository;
	private final ApplicationTypeRepository applicationTypeRepository;
	private final EntryCategoryMapper entryCategoryMapper;
	private final ApplicationTypeMapper applicationTypeMapper;

	public ReferenceDataServiceImpl(EntryCategoryRepository entryCategoryRepository,
			ApplicationTypeRepository applicationTypeRepository, 
			 EntryCategoryMapper entryCategoryMapper,
			ApplicationTypeMapper applicationTypeMapper, RegionMapper regionMapper, DistrictMapper districtMapper) {
		this.entryCategoryRepository = entryCategoryRepository;
		this.applicationTypeRepository = applicationTypeRepository;
		this.entryCategoryMapper = entryCategoryMapper;
		this.applicationTypeMapper = applicationTypeMapper;
	
	}

	@Cacheable
	@Override
	public List<EntryCategoryDTO> getAllEntryCategories() {
		return mapList(entryCategoryRepository.findAll(), entryCategoryMapper::toDTO);
	}

	@Cacheable
	@Override
	public List<ApplicationTypeDTO> getAllApplicationTypes() {

		return mapList(applicationTypeRepository.findAll(), applicationTypeMapper::toDTO);
	}

	private <E, D> List<D> mapList(List<E> entities, Function<E, D> mapper) {
		if (entities == null) {
			return Collections.emptyList();
		}
		return entities.stream().map(mapper).collect(Collectors.toUnmodifiableList());
	}

}
