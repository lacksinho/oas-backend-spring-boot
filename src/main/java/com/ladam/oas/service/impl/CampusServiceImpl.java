package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ladam.oas.dto.CampusDTO;
import com.ladam.oas.dto.CampusRequest;
import com.ladam.oas.mapper.CampusMapper;
import com.ladam.oas.model.Campus;
import com.ladam.oas.repository.CampusRepository;
import com.ladam.oas.service.CampusService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class CampusServiceImpl implements CampusService {

	private final EntityHelperService entityHelperService;
	private final CampusRepository campusRepository;
	private final CampusMapper mapper;

	public CampusServiceImpl(EntityHelperService entityHelperService, CampusRepository campusRepository,
			CampusMapper campusMapper) {
		this.entityHelperService = entityHelperService;
		this.campusRepository = campusRepository;
		this.mapper = campusMapper;
	}

	@Override
	public List<CampusDTO> getAllCampuses() {

		return entityHelperService.mapList(campusRepository.findAll(), mapper::toDTO);
	}

	@Override
	public CampusDTO getCampusById(Long id) {
		Campus campus = entityHelperService.getByIdOrThrow(campusRepository, id, "Campus");

		return mapper.toDTO(campus);
	}

	@Override
	public CampusDTO addCampus(CampusRequest campusRequest) {
		return mapper.toDTO(campusRepository.save(mapper.toEntity(campusRequest, new Campus())));
	}

	@Override
	public CampusDTO updateCampus(Long id, CampusRequest campusRequest) {
		Campus campus = entityHelperService.getByIdOrThrow(campusRepository, id, "Campus");
		return mapper.toDTO(campusRepository.save(mapper.toEntity(campusRequest, campus)));
	}

}
