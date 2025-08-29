package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.ApplicantDTO;
import com.ladam.oas.dto.ApplicantRequest;
import com.ladam.oas.model.Applicant;

@Component
public class ApplicantMapper {

	private final ModelMapper modelMapper;

	public ApplicantMapper(ModelMapper mapper) {
		this.modelMapper = mapper;

		modelMapper.addMappings(new PropertyMap<ApplicantRequest, Applicant>() {
			@Override
			protected void configure() {
				skip(destination.getId());
				skip(destination.getApplicantNumber());
				skip(destination.getEntryCategory());
				skip(destination.getApplicationType());
				skip(destination.getDisability());
				skip(destination.getNationality());
				skip(destination.getRegion());
				skip(destination.getDistrict());
				skip(destination.getFormFourIndex());
			}
		});
	}

	public ApplicantDTO toDTO(Applicant applicant) {
		return modelMapper.map(applicant, ApplicantDTO.class);
	}

	public Applicant toEntity(ApplicantRequest request, Applicant applicant) {
		if (request == null)
			return null;

		if (applicant == null) {
			applicant = new Applicant();
		}
		
		modelMapper.map(request, applicant);

		return applicant;
	}
}
