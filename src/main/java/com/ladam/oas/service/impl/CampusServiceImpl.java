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
	private final CampusMapper campusMapper;

	public CampusServiceImpl(EntityHelperService entityHelperService, CampusRepository campusRepository,
			CampusMapper campusMapper) {
		this.entityHelperService = entityHelperService;
		this.campusRepository = campusRepository;
		this.campusMapper = campusMapper;
	}

	@Override
	public List<CampusDTO> getAllCampuses() {

		return entityHelperService.mapList(campusRepository.findAll(), campusMapper::toDTO);
	}

	@Override
	public CampusDTO findCampusById(Long id) {
		Campus campus = entityHelperService.getByIdOrThrow(campusRepository, id, "Campus");

		return campusMapper.toDTO(campus);
	}

	@Override
	public CampusDTO addCampus(CampusRequest campusRequest) {
		Campus campus = campusMapper.toEntity(campusRequest);
		return campusMapper.toDTO(campusRepository.save(campus));
	}

	@Override
	public CampusDTO updateCampus(Long id, CampusRequest campusRequest) {
		Campus campus = entityHelperService.getByIdOrThrow(campusRepository, id, "Campus");
		updateCampusFields(campusRequest, campus);
		return campusMapper.toDTO(campusRepository.save(campus));
	}

	private void updateCampusFields(CampusRequest campusRequest, Campus campus) {
		campus.setCode(campusRequest.getCode());
		campus.setName(campusRequest.getName());
		campus.setShortName(campusRequest.getShortName());
		campus.setLocation(campusRequest.getLocation());
		campus.setIsActive(campusRequest.getIsActive());
	}

}
