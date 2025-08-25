package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.ProgrammeDTO;
import com.ladam.oas.dto.ProgrammeRequest;

public interface ProgrammeService {

	List<ProgrammeDTO> getAllProgrammes();

	ProgrammeDTO findProgrammeById(Long id);

	ProgrammeDTO addProgramme(ProgrammeRequest request);

	ProgrammeDTO updateProgramme(Long id, ProgrammeRequest request);

	void deleteProgramme(Long id);

}
