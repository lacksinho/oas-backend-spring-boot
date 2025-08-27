package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.NtaLevelDTO;
import com.ladam.oas.dto.NtaLevelRequest;

public interface NtaLevelService {
	
	List<NtaLevelDTO> getAllNtaLevels();
	NtaLevelDTO getNtaLevelById(Long id);
	NtaLevelDTO addNtaLevel(NtaLevelRequest request);
	NtaLevelDTO updateNtaLevel(Long id,NtaLevelRequest request);

}
