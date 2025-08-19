package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ladam.oas.dto.EntryCategoryDTO;
import com.ladam.oas.mapper.EntryCategoryMapper;
import com.ladam.oas.model.EntryCategory;
import com.ladam.oas.repository.EntryCategoryRepository;
import com.ladam.oas.service.EntryCategoryService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class EntryCategoryServiceImpl implements EntryCategoryService {

	private final EntityHelperService entityHelperService;
	private final EntryCategoryRepository entryCategoryRepository;
	private final EntryCategoryMapper entryCategoryMapper;

	public EntryCategoryServiceImpl(EntityHelperService entityHelperService,
			EntryCategoryRepository entryCategoryRepository, EntryCategoryMapper entryCategoryMapper) {
		this.entityHelperService = entityHelperService;
		this.entryCategoryRepository = entryCategoryRepository;
		this.entryCategoryMapper = entryCategoryMapper;

	}

	@Cacheable
	@Override
	public List<EntryCategoryDTO> getAllEntryCategories() {

		return entityHelperService.mapList(entryCategoryRepository.findAll(), entryCategoryMapper::toDTO);
	}

	@Override
	public EntryCategoryDTO findEntryCategoryById(Long id) {
		EntryCategory entryCategory = entityHelperService.getByIdOrThrow(entryCategoryRepository, id, "EntryCategory");

		return entryCategoryMapper.toDTO(entryCategory);
	}

}
