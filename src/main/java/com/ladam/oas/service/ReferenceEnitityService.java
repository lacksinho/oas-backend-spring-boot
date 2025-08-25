package com.ladam.oas.service;

import org.springframework.stereotype.Service;

import com.ladam.oas.model.ApplicationType;
import com.ladam.oas.model.Authority;
import com.ladam.oas.model.Campus;
import com.ladam.oas.model.Faculty;
import com.ladam.oas.model.NtaLevel;
import com.ladam.oas.repository.ApplicationTypeRepository;
import com.ladam.oas.repository.AuthorityRepository;
import com.ladam.oas.repository.CampusRepository;
import com.ladam.oas.repository.FacultyRepository;
import com.ladam.oas.repository.NtaLevelRepository;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class ReferenceEnitityService {

	private final EntityHelperService helperService;
	private final CampusRepository campusRepository;
	private final FacultyRepository facultyRepository;
	private final AuthorityRepository authorityRepository;
	private final ApplicationTypeRepository applicationTypeRepository;
	private final NtaLevelRepository ntaLevelRepository;

	public ReferenceEnitityService(EntityHelperService helperService, CampusRepository campusRepository,
			FacultyRepository facultyRepository, AuthorityRepository authorityRepository,
			ApplicationTypeRepository applicationTypeRepository, NtaLevelRepository ntaLevelRepository) {
		this.helperService = helperService;
		this.campusRepository = campusRepository;
		this.facultyRepository = facultyRepository;
		this.authorityRepository = authorityRepository;
		this.applicationTypeRepository = applicationTypeRepository;
		this.ntaLevelRepository = ntaLevelRepository;
	}

	public Campus getCampus(Long id) {
		return helperService.getByIdOrThrow(campusRepository, id, "Campus");
	}

	public Faculty getFaculty(Long id) {
		return helperService.getByIdOrThrow(facultyRepository, id, "Faculty");
	}

	public Authority getAuthority(Long id) {
		return helperService.getByIdOrThrow(authorityRepository, id, "Authority");
	}

	public ApplicationType getApplicationType(Long id) {
		return helperService.getByIdOrThrow(applicationTypeRepository, id, "ApplicationType");
	}

	public NtaLevel getNtaLevel(Long id) {
		return helperService.getByIdOrThrow(ntaLevelRepository, id, "NtaLevel");
	}

}
