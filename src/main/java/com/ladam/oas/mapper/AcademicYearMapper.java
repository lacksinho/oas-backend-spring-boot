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
		return modelMapper.map(academicYear, AcademicYearDTO.class);
	}

	public AcademicYear toEntity(AcademicYearDTO academicYearDTO) {
		return modelMapper.map(academicYearDTO, AcademicYear.class);
	}

	public AcademicYear toEntity(AcademicYearRequest academicYearRequest) {
		return modelMapper.map(academicYearRequest, AcademicYear.class);
	}

}
