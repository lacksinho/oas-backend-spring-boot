package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.ProgrammeDTO;
import com.ladam.oas.dto.ProgrammeRequest;
import com.ladam.oas.model.Programme;

@Component
public class ProgrammeMapper {

	private final ModelMapper modelMapper;

	public ProgrammeMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public ProgrammeDTO toDTO(Programme programme) {
		if (programme == null) {
			return null;
		}
		return modelMapper.map(programme, ProgrammeDTO.class);
	}

	public Programme toEntity(ProgrammeDTO programmeDTO) {
		if (programmeDTO == null) {
			return null;
		}
		return modelMapper.map(programmeDTO, Programme.class);
	}

	public Programme toEntity(ProgrammeRequest programmeRequest) {

		if (programmeRequest == null) {
			return null;
		}

		Programme programme = updateProgrammeFields(programmeRequest, new Programme());

		return programme;
	}

	private Programme updateProgrammeFields(ProgrammeRequest programmeRequest, Programme programme) {
		programme.setCode(programmeRequest.getCode());
		programme.setShortName(programmeRequest.getShortName());
		programme.setTitle(programmeRequest.getTitle());
		programme.setAlternativeTitle(programmeRequest.getAlternativeTitle());
		programme.setDuration(programmeRequest.getDuration());
		programme.setAuthorityCode(programmeRequest.getAuthorityCode());
		programme.setIsActive(programmeRequest.getIsActive());
		programme.setIsOpen(programmeRequest.getIsOpen());
		return programme;
	}

}
