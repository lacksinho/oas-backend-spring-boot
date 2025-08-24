package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.CampusDTO;
import com.ladam.oas.dto.CampusRequest;
import com.ladam.oas.model.Campus;

@Component
public class CampusMapper {

	private final ModelMapper modelMapper;

	public CampusMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public CampusDTO toDTO(Campus campus) {
		if (campus == null) {
			return null;
		}
		return modelMapper.map(campus, CampusDTO.class);
	}

	public Campus toEntity(CampusDTO campusDTO) {
		if (campusDTO == null) {
			return null;
		}
		return modelMapper.map(campusDTO, Campus.class);
	}

	public Campus toEntity(CampusRequest campusRequest) {
		if (campusRequest == null) {
			return null;
		}
		return modelMapper.map(campusRequest, Campus.class);
	}

}
