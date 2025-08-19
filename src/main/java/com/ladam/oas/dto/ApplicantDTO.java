package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDTO {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private String formFourIndex;
    private String email;
    private String mobileNumber;
    private String submitted;
}
