package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.CampusDTO;
import com.ladam.oas.dto.CampusRequest;

public interface CampusService {

	List<CampusDTO> getAllCampuses();

	CampusDTO getCampusById(Long id);

	CampusDTO addCampus(CampusRequest campusRequest);

	CampusDTO updateCampus(Long id, CampusRequest campusRequest);

}
