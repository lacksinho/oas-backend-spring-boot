package com.ladam.oas.service;

import java.util.List;

import com.ladam.oas.dto.ApplicationTypeDTO;
import com.ladam.oas.dto.EntryCategoryDTO;

public interface ReferenceDataService {

	List<EntryCategoryDTO> getAllEntryCategories();

	List<ApplicationTypeDTO> getAllApplicationTypes();

}
