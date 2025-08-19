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
		return modelMapper.map(district, DistrictDTO.class);
	}

	public District toEntity(DistrictDTO districtDTO) {
		return modelMapper.map(districtDTO, District.class);
	}

}
