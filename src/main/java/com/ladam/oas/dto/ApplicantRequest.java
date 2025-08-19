package com.ladam.oas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private String email;
    private String mobileNumber;
    private Integer appType;
    private Integer entryMode;
    private Integer disability;
    private Integer nationality;
    private Integer maritalStatus;

}
