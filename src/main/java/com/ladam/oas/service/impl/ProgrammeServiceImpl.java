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
	private final ReferenceEnitityService referenceEnitityService;
	private final ProgrammeRepository repository;
	private ProgrammeMapper mapper;

	public ProgrammeServiceImpl(EntityHelperService helperService, ReferenceEnitityService referenceEnitityService,
			ProgrammeRepository repository, ProgrammeMapper mapper) {
		this.helperService = helperService;
		this.referenceEnitityService = referenceEnitityService;
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<ProgrammeDTO> getAllProgrammes() {
		return helperService.mapList(repository.findAll(), mapper::toDTO);
	}

	@Override
	public ProgrammeDTO findProgrammeById(Long id) {
		return mapper.toDTO(helperService.getByIdOrThrow(repository, id, "Programme"));
	}

	@Override
	public ProgrammeDTO addProgramme(ProgrammeRequest request) {
		Programme programme = mapper.toEntity(request);
		updateEntityRetionshipFields(request, programme);
		return mapper.toDTO(repository.save(programme));
	}

	@Override
	public ProgrammeDTO updateProgramme(Long id, ProgrammeRequest request) {
		Programme programme = helperService.getByIdOrThrow(repository, id, "Programme");
		updateEntityFields(request, programme);
		updateEntityRetionshipFields(request, programme);
		return mapper.toDTO(repository.save(programme));
	}

	@Override
	public void deleteProgramme(Long id) {
		repository.delete(helperService.getByIdOrThrow(repository, id, "Programme"));
	}

	private void updateEntityFields(ProgrammeRequest request, Programme programme) {
		programme.setCode(request.getCode());
		programme.setShortName(request.getShortName());
		programme.setTitle(request.getTitle());
		programme.setAlternativeTitle(request.getAlternativeTitle());
		programme.setDuration(request.getDuration());
		programme.setAuthorityCode(request.getAuthorityCode());
		programme.setIsActive(request.getIsActive());
		programme.setIsOpen(request.getIsOpen());
	}

	private void updateEntityRetionshipFields(ProgrammeRequest request, Programme programme) {
		programme.setCampus(referenceEnitityService.getCampus(request.getCampusId()));
		programme.setFaculty(referenceEnitityService.getFaculty(request.getFacultyId()));
		programme.setNtaLevel(referenceEnitityService.getNtaLevel(request.getNtaLevelId()));
		programme.setAuthority(referenceEnitityService.getAuthority(request.getAuthorityId()));
		programme.setApplicationType(referenceEnitityService.getApplicationType(request.getApplicationTypeId()));
	}

}
