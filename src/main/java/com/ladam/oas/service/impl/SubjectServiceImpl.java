package com.ladam.oas.service.impl;

import java.util.List;

import com.ladam.oas.dto.SubjectDTO;
import com.ladam.oas.dto.SubjectRequest;
import com.ladam.oas.mapper.SubjectMapper;
import com.ladam.oas.model.Subject;
import com.ladam.oas.repository.SubjectRepository;
import com.ladam.oas.service.SubjectService;
import com.ladam.oas.utils.EntityHelperService;

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
		return helperService.mapList(repository.findAll(), mapper::toDTO);
	}

	@Override
	public SubjectDTO findSubjectById(Long id) {
		return mapper.toDTO(helperService.getByIdOrThrow(repository, id, "Subject"));
	}

	@Override
	public SubjectDTO addSubject(SubjectRequest request) {
		return mapper.toDTO(repository.save(mapper.toEntity(request)));
	}

	@Override
	public SubjectDTO updateSubject(Long id, SubjectRequest request) {
		Subject subject = helperService.getByIdOrThrow(repository, id, "Subject");
		updateEntityFields(request, subject);
		
		return mapper.toDTO(repository.save(subject));
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
		subject.setIsAtive(request.getIsAtive());
	}

}
