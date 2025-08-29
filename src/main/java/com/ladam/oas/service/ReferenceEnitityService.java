package com.ladam.oas.service;

import org.springframework.stereotype.Service;

import com.ladam.oas.model.ApplicationType;
import com.ladam.oas.model.Authority;
import com.ladam.oas.model.Campus;
import com.ladam.oas.model.Country;
import com.ladam.oas.model.Disability;
import com.ladam.oas.model.District;
import com.ladam.oas.model.EntryCategory;
import com.ladam.oas.model.Faculty;
import com.ladam.oas.model.NtaLevel;
import com.ladam.oas.model.Region;
import com.ladam.oas.model.Subject;
import com.ladam.oas.repository.ApplicationTypeRepository;
import com.ladam.oas.repository.AuthorityRepository;
import com.ladam.oas.repository.CampusRepository;
import com.ladam.oas.repository.CountryRepository;
import com.ladam.oas.repository.DisabilityRepository;
import com.ladam.oas.repository.DistrictRepository;
import com.ladam.oas.repository.EntryCategoryRepository;
import com.ladam.oas.repository.FacultyRepository;
import com.ladam.oas.repository.NtaLevelRepository;
import com.ladam.oas.repository.RegionRepository;
import com.ladam.oas.repository.SubjectRepository;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class ReferenceEnitityService {

	private final EntityHelperService helperService;
	private final CampusRepository campusRepository;
	private final FacultyRepository facultyRepository;
	private final AuthorityRepository authorityRepository;
	private final EntryCategoryRepository entryCategoryRepository;
	private final ApplicationTypeRepository applicationTypeRepository;
	private final NtaLevelRepository ntaLevelRepository;
	private final SubjectRepository subjectRepository;
	private final RegionRepository regionRepository;
	private final DistrictRepository districtRepository;
	private final DisabilityRepository disabilityRepository;
	private final CountryRepository countryRepository;

	public ReferenceEnitityService(EntityHelperService helperService, CampusRepository campusRepository,
			FacultyRepository facultyRepository, AuthorityRepository authorityRepository,
			EntryCategoryRepository entryCategoryRepository, ApplicationTypeRepository applicationTypeRepository,
			NtaLevelRepository ntaLevelRepository, SubjectRepository subjectRepository,
			RegionRepository regionRepository, DistrictRepository districtRepository,
			DisabilityRepository disabilityRepository, CountryRepository countryRepository) {
		super();
		this.helperService = helperService;
		this.campusRepository = campusRepository;
		this.facultyRepository = facultyRepository;
		this.authorityRepository = authorityRepository;
		this.entryCategoryRepository = entryCategoryRepository;
		this.applicationTypeRepository = applicationTypeRepository;
		this.ntaLevelRepository = ntaLevelRepository;
		this.subjectRepository = subjectRepository;
		this.regionRepository = regionRepository;
		this.districtRepository = districtRepository;
		this.disabilityRepository = disabilityRepository;
		this.countryRepository = countryRepository;
	}



	public Region getRegion(Long id) {
		return helperService.getByIdOrThrow(regionRepository, id, "Region");
	}
	
	public District getDistrict(Long id) {
		return helperService.getByIdOrThrow(districtRepository, id, "District");
	}
	
	public Country getNationlity(Long id) {
		return helperService.getByIdOrThrow(countryRepository, id, "Country");
	}
	
	public Disability getDisability(Long id) {
		return helperService.getByIdOrThrow(disabilityRepository, id, "Disability");
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
	
	public EntryCategory getEntryCategory(Long id) {
		return helperService.getByIdOrThrow(entryCategoryRepository, id, "EntryCategory");
	}

	public ApplicationType getApplicationType(Long id) {
		return helperService.getByIdOrThrow(applicationTypeRepository, id, "ApplicationType");
	}

	public NtaLevel getNtaLevel(Long id) {
		return helperService.getByIdOrThrow(ntaLevelRepository, id, "NtaLevel");
	}

	public Subject getSubject(Long id) {
		return helperService.getByIdOrThrow(subjectRepository, id, "Subject");
	}

}
