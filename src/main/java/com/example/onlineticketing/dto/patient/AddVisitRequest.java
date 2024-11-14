package com.example.onlineticketing.dto.patient;

import com.example.onlineticketing.comms.validator.ValidEmail;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddVisitRequest {
    @NotNull(message = "full name can not be null")
    @NotBlank(message = "full name can not be blank")
    private String fullName;

    @NotNull(message = "full name can not be null")
    @NotBlank(message = "full name can not be blank")
    private String phoneNumber;

    @ValidEmail(message = "Email not valid")
    private String email;

    private String gender;

    // yyyy-mm-dd
    private String dateOfBirth;

    private String complaint;
}
