package com.ladam.oas.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ladam.oas.dto.ApplicantDTO;
import com.ladam.oas.dto.ApplicantListDTO;
import com.ladam.oas.dto.ApplicantRequest;
import com.ladam.oas.exception.ResourceNotFoundException;
import com.ladam.oas.mapper.ApplicantMapper;
import com.ladam.oas.model.Applicant;
import com.ladam.oas.repository.ApplicantRepository;
import com.ladam.oas.service.ApplicantService;
import com.ladam.oas.utils.AppConstants;
import com.ladam.oas.utils.EntityHelperService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	private ApplicantRepository applicantRepository;
	private ApplicantMapper applicantMapper;
	private EntityHelperService entityHelperService;

	public ApplicantServiceImpl(ApplicantRepository applicantRepository, ApplicantMapper applicantMapper,
			EntityHelperService entityHelperService) {
		this.applicantRepository = applicantRepository;
		this.applicantMapper = applicantMapper;
		this.entityHelperService = entityHelperService;
	}

	@Override
	public ApplicantDTO getApplicantById(Long id) {
		Applicant applicant = entityHelperService.getApplicantByIdOrThrow(id);

		return applicantMapper.toDTO(applicant);
	}

	@Override
	public ApplicantDTO getApplicantByIndex(String indexNumber) {
		Applicant applicant = applicantRepository.getApplicantByFormFourIndex(indexNumber);

		if (applicant == null) {
			throw new ResourceNotFoundException("Applicant", "indexNumber", indexNumber);
		}

		return applicantMapper.toDTO(applicant);
	}

	@Override
	public void deleteApplicantById(Long id) {
		Applicant applicant = entityHelperService.getApplicantByIdOrThrow(id);
		applicantRepository.delete(applicant);
	}

	@Override
	public ApplicantDTO createApplicant(ApplicantRequest applicantRequest) {
		Applicant applicant = applicantMapper.toEntity(applicantRequest);
//        applicant.setAcademicYear(AppConstants.ACADEMIC_YEAR);
//        applicant.setAppLevel(AppConstants.BACHELOR_APP_LEVEL);
//        applicant.setAppRound(AppConstants.BACHELOR_APP_LEVEL);
		Applicant createdApplicant = applicantRepository.save(applicant);
		return applicantMapper.toDTO(createdApplicant);
	}

	@Override
	public ApplicantDTO updateApplicant(Long applicantId, ApplicantRequest applicantRequest) {

		Applicant applicant = entityHelperService.getApplicantByIdOrThrow(applicantId);
		updateApplicantFields(applicantRequest, applicant);
		System.out.println(applicant);
		Applicant updatedApplicant = applicantRepository.save(applicant);

		return applicantMapper.toDTO(updatedApplicant);
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
//        applicant.setSubmitted(submissionStatus);
		Applicant updatedApplicant = applicantRepository.save(applicant);
		return applicantMapper.toDTO(updatedApplicant);
	}

	private static void updateApplicantFields(ApplicantRequest applicantRequest, Applicant applicant) {
		applicant.setFirstName(applicantRequest.getFirstName());
		applicant.setMiddleName(applicantRequest.getMiddleName());
		applicant.setLastName(applicantRequest.getLastName());
		applicant.setBirthDate(applicantRequest.getBirthDate());
		applicant.setGender(applicantRequest.getGender());
		applicant.setMobileNumber(applicantRequest.getMobileNumber());
		applicant.setEmail(applicantRequest.getEmail());
		applicant.setMaritalStatus(applicantRequest.getMaritalStatus());
		applicant.setDisability(applicantRequest.getDisability());
//        applicant.setNationality(applicantRequest.getNationality());
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
				applicants = applicantRepository
						.findByIsSubmittedAndFirstNameContainingIgnoreCaseOrIsSubmittedAndLastNameContainingIgnoreCaseOrIsSubmittedAndFormFourIndexContainingIgnoreCase(
								submitted, search, submitted, search, submitted, search, pageable);
			} else {
				applicants = applicantRepository.findByIsSubmitted(submitted, pageable);
			}
		} else {

			if (hasSearch) {
				applicants = applicantRepository
						.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrFormFourIndexContainingIgnoreCase(
								search, search, search, pageable);
			} else {
				applicants = applicantRepository.findAll(pageable);
			}
		}

		List<Applicant> listOfApplicants = applicants.getContent();
		List<ApplicantDTO> content = listOfApplicants.stream().map(applicant -> applicantMapper.toDTO(applicant))
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
}