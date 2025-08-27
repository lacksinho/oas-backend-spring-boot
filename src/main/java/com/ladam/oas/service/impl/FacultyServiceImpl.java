package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ladam.oas.dto.FacultyDTO;
import com.ladam.oas.dto.FacultyRequest;
import com.ladam.oas.mapper.FacultyMapper;
import com.ladam.oas.model.Faculty;
import com.ladam.oas.repository.CampusRepository;
import com.ladam.oas.repository.FacultyRepository;
import com.ladam.oas.service.FacultyService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class FacultyServiceImpl implements FacultyService {

	private final EntityHelperService helperService;
	private final FacultyRepository repository;
	private final CampusRepository campusRepository;
	private final FacultyMapper mapper;

	public FacultyServiceImpl(EntityHelperService helperService, FacultyRepository repository,
			CampusRepository campusRepository, FacultyMapper mapper) {
		this.helperService = helperService;
		this.repository = repository;
		this.campusRepository = campusRepository;
		this.mapper = mapper;
	}

	@Override
	public List<FacultyDTO> getAllFaculties() {

		return helperService.mapList(repository.findAll(), mapper::toDTO);
	}

	@Override
	public FacultyDTO getFacultyById(Long id) {
		return mapper.toDTO(helperService.getByIdOrThrow(repository, id, "Faculty"));
	}

	@Override
	public FacultyDTO addFaculty(FacultyRequest request) {
		Faculty faculty = mapToEntityWithCampus(request);
		return mapper.toDTO(repository.save(faculty));
	}

	@Override
	public FacultyDTO updateFaculty(Long id, FacultyRequest request) {
		Faculty faculty = helperService.getByIdOrThrow(repository, id, "Faculty");
		updateEntityFields(request, faculty);
		return mapper.toDTO(repository.save(faculty));
	}

	
	@Override
	public void deleteFaculty(Long id) {
		repository.delete(helperService.getByIdOrThrow(repository, id, "Faculty"));
	}
	
	
	private void updateEntityFields(FacultyRequest request, Faculty faculty) {
		faculty.setName(request.getName());
		faculty.setIsActive(request.getIsActive());
		faculty.setCampus(helperService.getByIdOrThrow(campusRepository, request.getCampusId(), "Campus"));
	}
	
	private Faculty mapToEntityWithCampus(FacultyRequest request) {
		Faculty faculty = mapper.toEntity(request);
	   
	    faculty.setCampus(helperService.getByIdOrThrow(
	        campusRepository, request.getCampusId(), "Campus"
	    ));
		return faculty;
	}
}
