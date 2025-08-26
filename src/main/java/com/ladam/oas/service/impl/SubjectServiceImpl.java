package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ladam.oas.dto.SubjectDTO;
import com.ladam.oas.dto.SubjectRequest;
import com.ladam.oas.enums.SubjectCategory;
import com.ladam.oas.mapper.SubjectMapper;
import com.ladam.oas.model.Subject;
import com.ladam.oas.repository.SubjectRepository;
import com.ladam.oas.service.SubjectService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class SubjectServiceImpl implements SubjectService {

	private final EntityHelperService helperService;
	private final SubjectRepository repository;
	private final SubjectMapper mapper;

	public SubjectServiceImpl(EntityHelperService helperService, SubjectRepository repository, SubjectMapper mapper) {
		this.helperService = helperService;
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<SubjectDTO> getAllSubjects() {

		List<Subject> subjects = repository.findAll();

		return subjects.stream().map(this::mapToDTOWithCategory).toList();
	}

	@Override
	public SubjectDTO findSubjectById(Long id) {
		Subject subject = helperService.getByIdOrThrow(repository, id, "Subject");
		return mapToDTOWithCategory(subject);
	}

	@Override
	public SubjectDTO addSubject(SubjectRequest request) {
		Subject subject = repository.save(mapper.toEntity(request));
		return mapToDTOWithCategory(subject);
	}

	@Override
	public SubjectDTO updateSubject(Long id, SubjectRequest request) {
		Subject subject = helperService.getByIdOrThrow(repository, id, "Subject");
		updateEntityFields(request, subject);
		Subject updatedSubject = repository.save(subject);
		return mapToDTOWithCategory(updatedSubject);
	}

	@Override
	public void deleteSubject(Long id) {
		repository.delete(helperService.getByIdOrThrow(repository, id, "Subject"));

	}

	private void updateEntityFields(SubjectRequest request, Subject subject) {
		subject.setCode(request.getCode());
		subject.setShortName(request.getShortName());
		subject.setName(request.getName());
		subject.setCategoryCode(request.getCategoryCode());
		subject.setIsActive(request.getIsActive());
	}

	private SubjectDTO mapToDTOWithCategory(Subject subject) {
		SubjectDTO subjectDTO = mapper.toDTO(subject);
		if (subject.getCategoryCode() != null) {
			subjectDTO.setCategory(SubjectCategory.fromCode(subject.getCategoryCode()).getLabel());
		}
		return subjectDTO;
	}

}
