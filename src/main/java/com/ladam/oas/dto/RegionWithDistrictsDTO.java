package com.ladam.oas.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegionWithDistrictsDTO {
	private Long id;
	private String name;
	private List<DistrictDTO> districts;

}
