package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;

import com.ladam.oas.dto.FacultyDTO;
import com.ladam.oas.dto.FacultyRequest;
import com.ladam.oas.model.Campus;
import com.ladam.oas.model.Faculty;
import com.ladam.oas.repository.CampusRepository;
import com.ladam.oas.utils.EntityHelperService;

public class FacultyMapper {

	private final ModelMapper modelMapper;
	private final EntityHelperService entityHelperService;
	private final CampusRepository campusRepository;

	public FacultyMapper(ModelMapper modelMapper, EntityHelperService entityHelperService,
			CampusRepository campusRepository) {
		this.modelMapper = modelMapper;
		this.entityHelperService = entityHelperService;
		this.campusRepository = campusRepository;
	}

	public FacultyDTO toDTO(Faculty faculty) {
		return modelMapper.map(faculty, FacultyDTO.class);
	}

	public Faculty toEntity(FacultyDTO facultyDTO) {
		return modelMapper.map(facultyDTO, Faculty.class);
	}

	public Faculty toEntity(FacultyRequest facultyRequest) {

		Campus campus = entityHelperService.getByIdOrThrow(campusRepository, facultyRequest.getCampusId(), "Campus");

		Faculty faculty = new Faculty();
		faculty.setName(facultyRequest.getName());
		faculty.setIsActive(facultyRequest.getIsActive());
		faculty.setCampus(campus);

		return faculty;
	}

}
