package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantListDTO {
    private List<ApplicantDTO> content;
    private int pageNo;
    private int pageSize;
    private Long totalElements;
    private int totalPages;
    private boolean last;
}


