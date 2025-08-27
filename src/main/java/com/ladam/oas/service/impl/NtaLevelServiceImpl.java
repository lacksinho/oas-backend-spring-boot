package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ladam.oas.dto.NtaLevelDTO;
import com.ladam.oas.dto.NtaLevelRequest;
import com.ladam.oas.mapper.NtaLevelMapper;
import com.ladam.oas.model.NtaLevel;
import com.ladam.oas.repository.NtaLevelRepository;
import com.ladam.oas.service.NtaLevelService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class NtaLevelServiceImpl implements NtaLevelService {
	private EntityHelperService entityHelperService;
	private NtaLevelRepository ntaLevelRepository;
	private NtaLevelMapper ntaLevelMapper;

	public NtaLevelServiceImpl(EntityHelperService entityHelperService, NtaLevelRepository ntaLevelRepository,
			NtaLevelMapper ntaLevelMapper) {
		this.entityHelperService = entityHelperService;
		this.ntaLevelRepository = ntaLevelRepository;
		this.ntaLevelMapper = ntaLevelMapper;
	}

	@Override
	public List<NtaLevelDTO> getAllNtaLevels() {

		return entityHelperService.mapList(ntaLevelRepository.findAll(), ntaLevelMapper::toDTO);
	}

	@Override
	public NtaLevelDTO getNtaLevelById(Long id) {
		return ntaLevelMapper.toDTO(entityHelperService.getByIdOrThrow(ntaLevelRepository, id, "NtaLevel"));
	}

	@Override
	public NtaLevelDTO addNtaLevel(NtaLevelRequest request) {
		NtaLevel ntaLevel = ntaLevelMapper.toEntity(request);
		return ntaLevelMapper.toDTO(ntaLevelRepository.save(ntaLevel));
	}

	@Override
	public NtaLevelDTO updateNtaLevel(Long id, NtaLevelRequest request) {
		NtaLevel ntaLevel = entityHelperService.getByIdOrThrow(ntaLevelRepository, id, "NtaLevel");
		ntaLevel.setLevel(request.getLevel());
		ntaLevel.setIsActive(request.getIsActive());
		return ntaLevelMapper.toDTO(ntaLevelRepository.save(ntaLevel));
	}

}
