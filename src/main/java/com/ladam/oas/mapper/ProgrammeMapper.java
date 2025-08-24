package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.ProgrammeDTO;
import com.ladam.oas.dto.ProgrammeRequest;
import com.ladam.oas.model.Programme;
import com.ladam.oas.repository.ApplicationTypeRepository;
import com.ladam.oas.repository.AuthorityRepository;
import com.ladam.oas.repository.CampusRepository;
import com.ladam.oas.repository.FacultyRepository;
import com.ladam.oas.repository.NtaLevelRepository;
import com.ladam.oas.utils.EntityHelperService;

@Component
public class ProgrammeMapper {

	private final ModelMapper modelMapper;
	private final EntityHelperService entityHelperService;
	private final CampusRepository campusRepository;
	private final FacultyRepository facultyRepository;
	private final NtaLevelRepository ntaLevelRepository;
	private final AuthorityRepository authorityRepository;
	private final ApplicationTypeRepository applicationTypeRepository;

	public ProgrammeMapper(ModelMapper modelMapper, EntityHelperService entityHelperService,
			CampusRepository campusRepository, FacultyRepository facultyRepository,
			NtaLevelRepository ntaLevelRepository, AuthorityRepository authorityRepository,
			ApplicationTypeRepository applicationTypeRepository) {
		this.modelMapper = modelMapper;
		this.entityHelperService = entityHelperService;
		this.campusRepository = campusRepository;
		this.facultyRepository = facultyRepository;
		this.ntaLevelRepository = ntaLevelRepository;
		this.authorityRepository = authorityRepository;
		this.applicationTypeRepository = applicationTypeRepository;
	}

	public ProgrammeDTO toDTO(Programme programme) {
		return modelMapper.map(programme, ProgrammeDTO.class);
	}

	public Programme toEntity(ProgrammeDTO programmeDTO) {
		return modelMapper.map(programmeDTO, Programme.class);
	}

	public Programme toEntity(ProgrammeRequest programmeRequest) {

		Programme programme = updateProgrammeFields(programmeRequest, new Programme());

		return programme;
	}

	private Programme updateProgrammeFields(ProgrammeRequest programmeRequest, Programme programme) {	
		programme.setCode(programmeRequest.getCode());
		programme.setShortName(programmeRequest.getShortName());
		programme.setTitle(programmeRequest.getTitle());
		programme.setAlternativeTitle(programmeRequest.getAlternativeTitle());
		programme.setDuration(programmeRequest.getDuration());
		programme.setAuthorityCode(programmeRequest.getAuthorityCode());
		programme.setIsActive(programmeRequest.getIsActive());
		programme.setIsOpen(programmeRequest.getIsOpen());
		
		programme.setCampus(entityHelperService.getByIdOrThrow(campusRepository, programmeRequest.getCampusId(), "Campus"));
		programme.setFaculty(entityHelperService.getByIdOrThrow(facultyRepository, programmeRequest.getFacultyId(),"Faculty"));
		programme.setNtaLevel(entityHelperService.getByIdOrThrow(ntaLevelRepository, programmeRequest.getNtaLevelId(),"NtaLevel"));
		programme.setAuthority( entityHelperService.getByIdOrThrow(authorityRepository, programmeRequest.getAuthorityId(),"Authority"));
		programme.setApplicationType(entityHelperService.getByIdOrThrow(applicationTypeRepository,programmeRequest.getApplicationTypeId(), "ApplicationType"));
		return programme;
	}

}
