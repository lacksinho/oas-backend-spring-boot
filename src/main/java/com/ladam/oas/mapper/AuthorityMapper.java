package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.AuthorityDTO;
import com.ladam.oas.model.Authority;

@Component
public class AuthorityMapper {

	private final ModelMapper modelMapper;

	public AuthorityMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public AuthorityDTO toDTO(Authority authority) {
		if (authority == null) {
			return null;
		}
		return modelMapper.map(authority, AuthorityDTO.class);
	}

	public Authority toEntity(AuthorityDTO authorityDTO) {
		if (authorityDTO == null) {
			return null;
		}
		return modelMapper.map(authorityDTO, Authority.class);
	}

}
