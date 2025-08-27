package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ladam.oas.dto.ProgrammeDTO;
import com.ladam.oas.dto.ProgrammeRequest;
import com.ladam.oas.mapper.ProgrammeMapper;
import com.ladam.oas.model.Programme;
import com.ladam.oas.repository.ProgrammeRepository;
import com.ladam.oas.service.ProgrammeService;
import com.ladam.oas.service.ReferenceEnitityService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class ProgrammeServiceImpl implements ProgrammeService {
	private final EntityHelperService helperService;
	private final ReferenceEnitityService referenceEntityService;
	private final ProgrammeRepository repository;
	private ProgrammeMapper mapper;

	public ProgrammeServiceImpl(EntityHelperService helperService, ReferenceEnitityService referenceEntityService,
			ProgrammeRepository repository, ProgrammeMapper mapper) {
		this.helperService = helperService;
		this.referenceEntityService = referenceEntityService;
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<ProgrammeDTO> getAllProgrammes() {
		return helperService.mapList(repository.findAll(), mapper::toDTO);
	}

	@Override
	public ProgrammeDTO getProgrammeById(Long id) {
		return mapper.toDTO(helperService.getByIdOrThrow(repository, id, "Programme"));
	}

	@Override
	public ProgrammeDTO addProgramme(ProgrammeRequest request) {
		Programme programme = mapper.toEntity(request,new Programme());
		setRelationships(programme, request);
		return mapper.toDTO(repository.save(programme));
	}

	@Override
	public ProgrammeDTO updateProgramme(Long id, ProgrammeRequest request) {
		Programme programme = helperService.getByIdOrThrow(repository, id, "Programme");
		mapper.toEntity(request, programme);
		setRelationships(programme, request);
		return mapper.toDTO(repository.save(programme));
	}

	@Override
	public void deleteProgramme(Long id) {
		repository.delete(helperService.getByIdOrThrow(repository, id, "Programme"));
	}
	
	
	 private void setRelationships(Programme programme, ProgrammeRequest request) {
	        // set relationship fields
	        programme.setCampus(referenceEntityService.getCampus(request.getCampusId()));
	        programme.setFaculty(referenceEntityService.getFaculty(request.getFacultyId()));
	        programme.setNtaLevel(referenceEntityService.getNtaLevel(request.getNtaLevelId()));
	        programme.setAuthority(referenceEntityService.getAuthority(request.getAuthorityId()));
	        programme.setApplicationType(referenceEntityService.getApplicationType(request.getApplicationTypeId()));
	    }

}
