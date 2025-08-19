package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.EntryCategoryDTO;
import com.ladam.oas.model.EntryCategory;

@Component
public class EntryCategoryMapper {

	private ModelMapper modelMapper;

	public EntryCategoryMapper(ModelMapper mapper) {
		this.modelMapper = mapper;
	}

	public EntryCategoryDTO toDTO(EntryCategory entryCategory) {
		return modelMapper.map(entryCategory, EntryCategoryDTO.class);
	}

	public EntryCategory toEntity(EntryCategoryDTO entryCategoryDTO) {
		return modelMapper.map(entryCategoryDTO, EntryCategory.class);
	}
}