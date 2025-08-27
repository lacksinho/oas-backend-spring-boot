package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.SubjectDTO;
import com.ladam.oas.dto.SubjectRequest;

public interface SubjectService {

	List<SubjectDTO> getAllSubjects();

	SubjectDTO getSubjectById(Long id);

	SubjectDTO addSubject(SubjectRequest request);

	SubjectDTO updateSubject(Long id, SubjectRequest request);

	void deleteSubject(Long id);

}
