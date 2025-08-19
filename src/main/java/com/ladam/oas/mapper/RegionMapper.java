package com.ladam.oas.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.DistrictDTO;
import com.ladam.oas.dto.RegionDTO;
import com.ladam.oas.dto.RegionWithDistrictsDTO;
import com.ladam.oas.model.Region;

@Component
public class RegionMapper {

	private ModelMapper modelMapper;
	private DistrictMapper districtMapper;

	public RegionMapper(ModelMapper modelMapper, DistrictMapper districtMapper) {
		this.modelMapper = modelMapper;
		this.districtMapper = districtMapper;
	}

	public RegionDTO toDTO(Region region) {
		return modelMapper.map(region, RegionDTO.class);
	}

	public Region toEntity(RegionDTO regionDTO) {
		return modelMapper.map(regionDTO, Region.class);
	}

	public RegionWithDistrictsDTO toRegionWithDistrictsDTO(Region region) {
		List<DistrictDTO> districtDTOs = region.getDistricts().stream().map(districtMapper::toDTO)
				.collect(Collectors.toList());

		return new RegionWithDistrictsDTO(region.getId(), region.getName(), districtDTOs);
	}

}
