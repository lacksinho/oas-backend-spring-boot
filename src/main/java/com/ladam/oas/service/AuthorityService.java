package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.AuthorityDTO;

public interface AuthorityService {


	List<AuthorityDTO> getAllAuthorities();

	AuthorityDTO getAuthorityById(Long id);

}
