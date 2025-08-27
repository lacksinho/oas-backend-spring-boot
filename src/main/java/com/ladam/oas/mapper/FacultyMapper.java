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

	public Faculty toEntity(FacultyRequest facultyRequest, Faculty faculty) {

		if (facultyRequest == null) {
			return null;
		}

		if (faculty == null) {
			faculty = new Faculty();
		}

		modelMapper.map(facultyRequest, faculty);

		return faculty;
	}

}
