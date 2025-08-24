package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;

import com.ladam.oas.dto.NtaLevelDTO;
import com.ladam.oas.dto.NtaLevelRequest;
import com.ladam.oas.model.NtaLevel;

public class NtaLevelMapper {

	private final ModelMapper modelMapper;

	public NtaLevelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public NtaLevelDTO toDTO(NtaLevel ntaLevel) {
		return modelMapper.map(ntaLevel, NtaLevelDTO.class);
	}

	public NtaLevel toEntity(NtaLevelDTO ntaLevelDTO) {
		return modelMapper.map(ntaLevelDTO, NtaLevel.class);
	}

	public NtaLevel toEntity(NtaLevelRequest ntaLevelRequest) {
		return modelMapper.map(ntaLevelRequest, NtaLevel.class);
	}

}
