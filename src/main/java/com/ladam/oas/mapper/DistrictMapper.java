package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.DistrictDTO;
import com.ladam.oas.model.District;

@Component
public class DistrictMapper {

	private ModelMapper modelMapper;

	public DistrictMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public DistrictDTO toDTO(District district) {
		if (district == null) {
			return null;
		}
		return modelMapper.map(district, DistrictDTO.class);
	}

	public District toEntity(DistrictDTO districtDTO) {
		if (districtDTO == null) {
			return null;
		}
		return modelMapper.map(districtDTO, District.class);
	}

}
