package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.ApplicantDTO;
import com.ladam.oas.dto.ApplicantRequest;
import com.ladam.oas.model.Applicant;

@Component
public class ApplicantMapper {

	private ModelMapper modelMapper;

	public ApplicantMapper(ModelMapper mapper) {
		this.modelMapper = mapper;
	}

	public ApplicantDTO toDTO(Applicant applicant) {
		return modelMapper.map(applicant, ApplicantDTO.class);
	}

	public Applicant toEntity(ApplicantRequest request, Applicant applicant) {
		if (request == null) {
			return null;
		}

		if (applicant == null) {
			applicant = new Applicant();
		}
		modelMapper.map(request, applicant);

		return applicant;
	}
}