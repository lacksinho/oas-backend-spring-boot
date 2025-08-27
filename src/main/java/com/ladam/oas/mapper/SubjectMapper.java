package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.SubjectDTO;
import com.ladam.oas.dto.SubjectRequest;
import com.ladam.oas.model.Subject;

@Component
public class SubjectMapper {

	private final ModelMapper modelMapper;

	public SubjectMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public SubjectDTO toDTO(Subject subject) {

		if (subject == null) {
			return null;
		}

		return modelMapper.map(subject, SubjectDTO.class);
	}

	public Subject toEntity(SubjectRequest subjectRequest, Subject subject) {
		if (subjectRequest == null) {
			return null;
		}

		if (subject == null) {
			subject = new Subject(); // create new if not provided
		}
		modelMapper.map(subjectRequest, subject);

		return subject;
	}

}
