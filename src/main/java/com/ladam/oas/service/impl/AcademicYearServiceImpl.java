package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ladam.oas.dto.AcademicYearDTO;
import com.ladam.oas.dto.AcademicYearRequest;
import com.ladam.oas.exception.OasApiException;
import com.ladam.oas.mapper.AcademicYearMapper;
import com.ladam.oas.model.AcademicYear;
import com.ladam.oas.repository.AcademicYearRepository;
import com.ladam.oas.service.AcademicYearService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class AcademicYearServiceImpl implements AcademicYearService {

	private final EntityHelperService entityHelperService;
	private final AcademicYearRepository repository;
	private final AcademicYearMapper mapper;

	public AcademicYearServiceImpl(EntityHelperService entityHelperService,
			AcademicYearRepository academicYearRepository, AcademicYearMapper academicYearMapper) {
		this.entityHelperService = entityHelperService;
		this.repository = academicYearRepository;
		this.mapper = academicYearMapper;
	}

	@Override
	public List<AcademicYearDTO> getAllAcademicYears() {

		return entityHelperService.mapList(repository.findAll(), mapper::toDTO);
	}

	@Override
	public AcademicYearDTO addAcademicYear(AcademicYearRequest academicYearRequest) {

		AcademicYear academicYear = mapper.toEntity(academicYearRequest, new AcademicYear());

		if (Boolean.TRUE.equals(academicYear.getIsActive())) {
			deactivateOtherAcademicYears();
		}
		return mapper.toDTO(repository.save(academicYear));
	}

	@Override
	public AcademicYearDTO updateAcademicYear(Long id, AcademicYearRequest academicYearRequest) {
		AcademicYear academicYear = entityHelperService.getByIdOrThrow(repository, id, "AcademicYear");

		if (Boolean.FALSE.equals(academicYearRequest.getIsActive())
				&& Boolean.TRUE.equals(academicYear.getIsActive())) {
			long activeCount = repository.countByIsActiveTrue();
			if (activeCount <= 1) {
				throw new OasApiException(HttpStatus.BAD_REQUEST, "There must be at least one active academic year");
			}
		}
		updateAcademicYearFields(academicYearRequest, academicYear);
		mapper.toEntity(academicYearRequest, academicYear);
		
		if (Boolean.TRUE.equals(academicYear.getIsActive())) {
			deactivateOtherAcademicYears();
		}

		return mapper.toDTO(repository.save(academicYear));
	}

	@Override
	public AcademicYearDTO getAcademicYearById(Long id) {

		AcademicYear academicYear = entityHelperService.getByIdOrThrow(repository, id, "AcademicYear");
		return mapper.toDTO(academicYear);
	}

	@Override
	public AcademicYearDTO getActiveAcademicYear() {
		AcademicYear academicYear = entityHelperService.getSingleActiveOrThrow(repository, "AcademicYear");
		return mapper.toDTO(academicYear);
	}

	private void updateAcademicYearFields(AcademicYearRequest academicYearRequest, AcademicYear academicYear) {
		academicYear.setYear(academicYearRequest.getYear());
		academicYear.setIsActive(academicYearRequest.getIsActive());
	}

	private void deactivateOtherAcademicYears() {
		repository.findByIsActiveTrue().ifPresent(existing -> {
			existing.setIsActive(false);
			repository.save(existing);
		});
	}
}
