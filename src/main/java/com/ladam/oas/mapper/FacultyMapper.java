package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.FacultyDTO;
import com.ladam.oas.dto.FacultyRequest;
import com.ladam.oas.model.Faculty;

@Component
public class FacultyMapper {

	private final ModelMapper modelMapper;

	public FacultyMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public FacultyDTO toDTO(Faculty faculty) {
		if (faculty == null) {
			return null;
		}
		return modelMapper.map(faculty, FacultyDTO.class);
	}

	public Faculty toEntity(FacultyDTO facultyDTO) {
		if (facultyDTO == null) {
			return null;
		}
		return modelMapper.map(facultyDTO, Faculty.class);
	}

	public Faculty toEntity(FacultyRequest facultyRequest) {

		if (facultyRequest == null) {
			return null;
		}

		Faculty faculty = new Faculty();
		faculty.setName(facultyRequest.getName());
		faculty.setIsActive(facultyRequest.getIsActive());

		return faculty;
	}

}
