package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictDTO {
	private Long id;
	private String name;	
	private RegionDTO region;

}
