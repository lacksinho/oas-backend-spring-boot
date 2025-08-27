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

	public Programme toEntity(ProgrammeRequest request, Programme programme) {

		if (request == null) {
			return null;
		}

		if (programme == null) {
			programme = new Programme(); // create new if not provided
		}

		modelMapper.map(request, programme);
		
		return programme;
	}

}
