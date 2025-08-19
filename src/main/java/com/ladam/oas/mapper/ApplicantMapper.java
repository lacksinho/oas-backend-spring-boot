package com.ladam.oas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ladam.oas.dto.ApplicantDTO;
import com.ladam.oas.dto.ApplicantRequest;
import com.ladam.oas.model.Applicant;
//import com.ladam.oas.utils.AppConstants;
import com.ladam.oas.utils.AppConstants;

@Component
public class ApplicantMapper {

    private ModelMapper modelMapper;

    public ApplicantMapper(ModelMapper mapper) {
        this.modelMapper = mapper;
    }

    public ApplicantDTO toDTO(Applicant applicant) {
        ApplicantDTO applicantDTO = new ApplicantDTO();
        applicantDTO.setId(applicant.getId());
        applicantDTO.setFirstName(applicant.getFirstName());
        applicantDTO.setMiddleName(applicant.getMiddleName());
        applicantDTO.setLastName(applicant.getLastName());
        applicantDTO.setGender(applicant.getGender());
        applicantDTO.setBirthDate(applicant.getBirthDate());
        applicantDTO.setFormFourIndex(applicant.getFormFourIndex());
        applicantDTO.setEmail(applicant.getEmail());
        applicantDTO.setMobileNumber(applicant.getMobileNumber());
        applicantDTO.setSubmitted(applicant.getIsSubmitted() == AppConstants.SUBMITTED_STATUS ? "YES" : "NO");
        return applicantDTO;
    }

    public Applicant toEntity(ApplicantDTO applicantDTO) {
        return modelMapper.map(applicantDTO, Applicant.class);
    }

    public Applicant toEntity(ApplicantRequest applicantRequest) {
        return modelMapper.map(applicantRequest, Applicant.class);
    }
}