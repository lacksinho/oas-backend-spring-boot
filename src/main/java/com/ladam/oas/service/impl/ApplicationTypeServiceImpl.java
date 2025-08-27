package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ladam.oas.dto.ApplicationTypeDTO;
import com.ladam.oas.mapper.ApplicationTypeMapper;
import com.ladam.oas.model.ApplicationType;
import com.ladam.oas.repository.ApplicationTypeRepository;
import com.ladam.oas.service.ApplicationTypeService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class ApplicationTypeServiceImpl implements ApplicationTypeService {

	private final EntityHelperService entityHelperService;
	private final ApplicationTypeRepository applicationTypeRepository;
	private final ApplicationTypeMapper applicationTypeMapper;

	public ApplicationTypeServiceImpl(EntityHelperService entityHelperService,ApplicationTypeRepository applicationTypeRepository,
			ApplicationTypeMapper applicationTypeMapper) {
		this.entityHelperService = entityHelperService;
		this.applicationTypeRepository = applicationTypeRepository;
		this.applicationTypeMapper = applicationTypeMapper;

	}

	@Cacheable
	@Override
	public List<ApplicationTypeDTO> getAllApplicationTypes() {	
		return entityHelperService.mapList(applicationTypeRepository.findAll(), applicationTypeMapper::toDTO);
	}

	@Override
	public ApplicationTypeDTO getApplicationTypeById(Long id) {
		
	ApplicationType  applicationType = entityHelperService.getByIdOrThrow(applicationTypeRepository, id, "ApplicationType");
		
		return applicationTypeMapper.toDTO(applicationType);
	}
}
