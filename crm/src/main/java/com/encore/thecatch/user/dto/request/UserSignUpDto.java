package com.encore.thecatch.user.dto.request;

import com.encore.thecatch.common.dto.Role;
import com.encore.thecatch.company.domain.Company;
import com.encore.thecatch.user.domain.Gender;
import com.encore.thecatch.user.domain.Grade;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserSignUpDto {
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String address;
    private String detailAddress;
    private String zipcode;
    private String phoneNumber;
    private Role role;
    private Grade grade;
    private boolean consentReceiveMarketing;
    private Long companyId;
    private Gender gender;

}
