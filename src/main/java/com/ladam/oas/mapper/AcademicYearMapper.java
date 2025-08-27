package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.AcademicYearDTO;
import com.ladam.oas.dto.AcademicYearRequest;
import com.ladam.oas.model.AcademicYear;

@Component
public class AcademicYearMapper {

	private ModelMapper modelMapper;

	public AcademicYearMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public AcademicYearDTO toDTO(AcademicYear academicYear) {
		if (academicYear == null) {
			return null;
		}
		return modelMapper.map(academicYear, AcademicYearDTO.class);
	}

	public AcademicYear toEntity(AcademicYearDTO academicYearDTO) {
		if (academicYearDTO == null) {
			return null;
		}
		return modelMapper.map(academicYearDTO, AcademicYear.class);
	}

	public AcademicYear toEntity(AcademicYearRequest academicYearRequest, AcademicYear academicYear) {
		if (academicYearRequest == null) {
			return null;
		}

		if (academicYear == null) {
			academicYear = new AcademicYear();
		}
		modelMapper.map(academicYearRequest, academicYear);

		return academicYear;
	}

}
