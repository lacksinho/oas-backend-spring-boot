package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.NtaLevelDTO;
import com.ladam.oas.dto.NtaLevelRequest;
import com.ladam.oas.model.NtaLevel;

@Component
public class NtaLevelMapper {

	private final ModelMapper modelMapper;

	public NtaLevelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public NtaLevelDTO toDTO(NtaLevel ntaLevel) {
		if (ntaLevel == null) {
			return null;
		}
		return modelMapper.map(ntaLevel, NtaLevelDTO.class);
	}

	public NtaLevel toEntity(NtaLevelRequest ntaLevelRequest, NtaLevel ntaLevel) {
		if (ntaLevelRequest == null) {
			return null;
		}

		if (ntaLevel == null) {
			ntaLevel = new NtaLevel();
		}

		modelMapper.map(ntaLevelRequest, ntaLevel);

		return ntaLevel;
	}

}
