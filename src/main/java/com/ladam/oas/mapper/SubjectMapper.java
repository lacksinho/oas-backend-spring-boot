package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;

import com.ladam.oas.dto.SubjectDTO;
import com.ladam.oas.dto.SubjectRequest;
import com.ladam.oas.enums.SubjectCategory;
import com.ladam.oas.model.Subject;

public class SubjectMapper {

	private final ModelMapper modelMapper;

	public SubjectMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public SubjectDTO toDTO(Subject subject) {

		if (subject == null) {
			return null;
		}

		SubjectDTO subjectDTO = new SubjectDTO();
		subjectDTO.setId(subject.getId());
		subjectDTO.setCode(subject.getCode());
		subjectDTO.setShortName(subject.getShortName());
		subjectDTO.setName(subject.getName());

		if (subject.getCategoryCode() != null) {
			subjectDTO.setCategory(SubjectCategory.fromCode(subject.getCategoryCode()).getLabel());
		}

		subjectDTO.setIsAtive(subject.getIsAtive());
		return subjectDTO;
	}

	public Subject toEntity(SubjectRequest subjectRequest) {
		if (subjectRequest == null) {
			return null;
		}
		return modelMapper.map(subjectRequest, Subject.class);
	}

	public Subject toEntity(SubjectDTO subjectDTO) {

		Subject subject = new Subject();
		subject.setCode(subjectDTO.getCode());
		subject.setShortName(subjectDTO.getShortName());
		subject.setName(subjectDTO.getName());

		if (subjectDTO.getCategory() != null) {
			subject.setCategoryCode(SubjectCategory.fromLabel(subjectDTO.getCategory()).getCode());
		}

		subject.setIsAtive(subjectDTO.getIsAtive());
		return subject;
	}

}
