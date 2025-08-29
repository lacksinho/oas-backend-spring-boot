package com.ladam.oas.service.impl;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ladam.oas.dto.ApplicantDTO;
import com.ladam.oas.dto.ApplicantListDTO;
import com.ladam.oas.dto.ApplicantRequest;
import com.ladam.oas.enums.MaritalStatus;
import com.ladam.oas.exception.OasApiException;
import com.ladam.oas.exception.ResourceNotFoundException;
import com.ladam.oas.mapper.ApplicantMapper;
import com.ladam.oas.model.Applicant;
import com.ladam.oas.repository.ApplicantRepository;
import com.ladam.oas.service.ApplicantService;
import com.ladam.oas.service.ReferenceEnitityService;
import com.ladam.oas.utils.AppConstants;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	private ApplicantRepository repository;
	private ApplicantMapper mapper;
	private EntityHelperService entityHelperService;
	private final ReferenceEnitityService referenceEntityService;

	public ApplicantServiceImpl(ApplicantRepository applicantRepository, ApplicantMapper applicantMapper,
			EntityHelperService entityHelperService, ReferenceEnitityService referenceEnitityService) {
		this.repository = applicantRepository;
		this.mapper = applicantMapper;
		this.entityHelperService = entityHelperService;
		this.referenceEntityService = referenceEnitityService;
	}

	@Override
	public ApplicantDTO getApplicantById(Long id) {
		Applicant applicant = entityHelperService.getApplicantByIdOrThrow(id);

		return mapToDTOWithMarialStatus(applicant);
	}

	@Override
	public ApplicantDTO getApplicantByIndex(String indexNumber) {
		Applicant applicant = repository.getApplicantByFormFourIndex(indexNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Applicant", "indexNumber", indexNumber));

		return mapToDTOWithMarialStatus(applicant);
	}

	@Override
	public void deleteApplicantById(Long id) {
		Applicant applicant = entityHelperService.getApplicantByIdOrThrow(id);
		repository.delete(applicant);
	}

	@Override
	public ApplicantDTO registerApplicant(ApplicantRequest request) {
		
		if (repository.existsByFormFourIndex(request.getFormFourIndex())) {
		    throw new OasApiException(HttpStatus.BAD_REQUEST,"Form four index '" + request.getFormFourIndex() + "' already exists");
		}

		Applicant applicant = mapper.toEntity(request, new Applicant());
		setRelationships(applicant, request);

		applicant = repository.save(applicant);

		applicant.setFormFourIndex(request.getFormFourIndex());
		applicant.setApplicantNumber(generateApplicantNumber(applicant));

		return mapToDTOWithMarialStatus(repository.save(applicant));
	}

	@Override
	public ApplicantDTO updateApplicant(Long applicantId, ApplicantRequest request) {
		Applicant applicant = entityHelperService.getApplicantByIdOrThrow(applicantId);
		
		mapper.toEntity(request, applicant);
		setRelationships(applicant, request);
		
		return mapToDTOWithMarialStatus(repository.save(applicant));
	}

	@Override
	public ApplicantDTO submitApplicant(Long applicantId) {
		return updateSubmissionStatus(applicantId, AppConstants.SUBMITTED_STATUS);
	}

	@Override
	public ApplicantDTO unsubmitApplicant(Long applicantId) {
		return updateSubmissionStatus(applicantId, AppConstants.UNSUBMITTED_STATUS);
	}

	private ApplicantDTO updateSubmissionStatus(Long applicantId, Boolean submissionStatus) {
		Applicant applicant = entityHelperService.getApplicantByIdOrThrow(applicantId);

		applicant.setIsSubmitted(submissionStatus);

		if (submissionStatus) {
			applicant.setSubmittedOn(LocalDate.now());
		} else {
			applicant.setSubmittedOn(null);
		}
		Applicant updatedApplicant = repository.save(applicant);
		return mapper.toDTO(updatedApplicant);
	}

	@Override
	public ApplicantListDTO getAllApplicants(int pageNo, int pageSize, String sortBy, String sortDir, String search,
			Boolean submitted) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<Applicant> applicants;

		boolean hasSearch = search != null && !search.trim().isEmpty();

		if (submitted != null) {
			// Apply filter
			if (hasSearch) {
				applicants = repository
						.findByIsSubmittedAndFirstNameContainingIgnoreCaseOrIsSubmittedAndLastNameContainingIgnoreCaseOrIsSubmittedAndFormFourIndexContainingIgnoreCase(
								submitted, search, submitted, search, submitted, search, pageable);
			} else {
				applicants = repository.findByIsSubmitted(submitted, pageable);
			}
		} else {

			if (hasSearch) {
				applicants = repository
						.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrFormFourIndexContainingIgnoreCase(
								search, search, search, pageable);
			} else {
				applicants = repository.findAll(pageable);
			}
		}

		List<Applicant> listOfApplicants = applicants.getContent();
		List<ApplicantDTO> content = listOfApplicants.stream().map(applicant -> mapToDTOWithMarialStatus(applicant))
				.collect(Collectors.toList());

		ApplicantListDTO applicantListDTO = new ApplicantListDTO();
		applicantListDTO.setContent(content);
		applicantListDTO.setPageNo(pageNo);
		applicantListDTO.setPageSize(pageSize);
		applicantListDTO.setTotalPages(applicants.getTotalPages());
		applicantListDTO.setTotalElements(applicants.getTotalElements());
		applicantListDTO.setLast(applicants.isLast());
		return applicantListDTO;
	}

	private ApplicantDTO mapToDTOWithMarialStatus(Applicant applicant) {
		ApplicantDTO applicantDTO = mapper.toDTO(applicant);
		if (applicant.getMaritalStatusId() != null) {
			applicantDTO.setMaritalStatus(MaritalStatus.fromCode(applicant.getMaritalStatusId()).getLabel());
			;
		}

		return applicantDTO;
	}

	private String generateApplicantNumber(Applicant applicant) {
		// Generate applicant number: APP-<id>-<year>
		return String.format("APP-%04d-%d", applicant.getId(), Year.now().getValue());
	}

	private void setRelationships(Applicant applicant, ApplicantRequest request) {
		// set relationship fields
		applicant.setEntryCategory(referenceEntityService.getEntryCategory(request.getEntryCategoryId()));
		applicant.setApplicationType(referenceEntityService.getApplicationType(request.getApplicationTypeId()));
		applicant.setDisability(referenceEntityService.getDisability(request.getDisabilityId()));
		applicant.setNationality(referenceEntityService.getNationlity(request.getNationalityId()));
		applicant.setRegion(referenceEntityService.getRegion(request.getRegionId()));
		applicant.setDistrict(referenceEntityService.getDistrict(request.getDistrictId()));

	}
}