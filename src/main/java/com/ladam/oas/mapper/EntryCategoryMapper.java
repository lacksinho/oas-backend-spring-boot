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
		if (entryCategory == null) {
			return null;
		}
		return modelMapper.map(entryCategory, EntryCategoryDTO.class);
	}
}