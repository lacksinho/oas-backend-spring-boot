package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.AcademicYearDTO;
import com.ladam.oas.dto.AcademicYearRequest;

public interface AcademicYearService {

	List<AcademicYearDTO> getAllAcademicYears();

	AcademicYearDTO addAcademicYear(AcademicYearRequest academicYearRequest);

	AcademicYearDTO updateAcademicYear(Long id, AcademicYearRequest academicYearRequest);

	AcademicYearDTO getAcademicYearById(Long id);

	AcademicYearDTO getActiveAcademicYear();

}
