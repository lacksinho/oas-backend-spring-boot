package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.ApplicationTypeDTO;
import com.ladam.oas.model.ApplicationType;

@Component
public class ApplicationTypeMapper {

	private ModelMapper modelMapper;

	public ApplicationTypeMapper(ModelMapper mapper) {
		this.modelMapper = mapper;
	}

	public ApplicationTypeDTO toDTO(ApplicationType applicationType) {
		if (applicationType == null) {
			return null;
		}
		return modelMapper.map(applicationType, ApplicationTypeDTO.class);
	}

	public ApplicationType toEntity(ApplicationTypeDTO applicationTypeDTO) {
		if (applicationTypeDTO == null) {
			return null;
		}
		return modelMapper.map(applicationTypeDTO, ApplicationType.class);
	}

}
