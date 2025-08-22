package com.ladam.oas.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ladam.oas.dto.AuthorityDTO;
import com.ladam.oas.mapper.AuthorityMapper;
import com.ladam.oas.model.Authority;
import com.ladam.oas.repository.AuthorityRepository;
import com.ladam.oas.service.AuthorityService;
import com.ladam.oas.utils.EntityHelperService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	private final EntityHelperService entityHelperService;
	private final AuthorityRepository authorityRepository;
	private final AuthorityMapper authorityMapper;

	public AuthorityServiceImpl(EntityHelperService entityHelperService, AuthorityRepository authorityRepository,
			AuthorityMapper authorityMapper) {
		this.entityHelperService = entityHelperService;
		this.authorityRepository = authorityRepository;
		this.authorityMapper = authorityMapper;
	}

	@Override
	public List<AuthorityDTO> getAllAuthorities() {

		return entityHelperService.mapList(authorityRepository.findAll(), authorityMapper::toDTO);
	}

	@Override
	public AuthorityDTO findAuthorityById(Long id) {
		Authority authority = entityHelperService.getByIdOrThrow(authorityRepository, id, "Authority");
		return authorityMapper.toDTO(authority);
	}

}
