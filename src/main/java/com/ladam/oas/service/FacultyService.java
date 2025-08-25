package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.FacultyDTO;
import com.ladam.oas.dto.FacultyRequest;

public interface FacultyService {

	List<FacultyDTO> getAllFaculties();

	FacultyDTO findFacultyById(Long id);

	FacultyDTO addFaculty(FacultyRequest request);

	FacultyDTO updateFaculty(Long id, FacultyRequest request);

	void deleteFaculty(Long id);

}
