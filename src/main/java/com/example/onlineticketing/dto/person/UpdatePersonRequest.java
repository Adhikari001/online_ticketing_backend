package com.example.onlineticketing.dto.person;

import com.example.onlineticketing.comms.validator.ValidEmail;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdatePersonRequest {
    @NotNull(message = "first name can not be null")
    @NotEmpty(message = "first name can not be empty")
    private String firstName;

    @NotNull(message = "last name can not be null")
    @NotEmpty(message = "last name can not be empty")
    private String lastName;

    @NotNull(message = "phone number is required")
    @Size(max = 10, min = 10, message = "Length of phone number is 10")
    private String phoneNumber;

    @NotNull(message = "email can not be null")
    @NotEmpty(message = "email can not be empty")
    @ValidEmail(message = "Provided email is not valid")
    private String email;

    @NotNull(message = "gender can not be null")
    @NotEmpty(message = "gender can not be empty")
    private String gender;

    @NotNull(message = "role can not be null")
    private Long roleId;

    @NotNull(message = "is active can not be null")
    private Boolean isActive;

    @NotNull(message = "is active can not be null")
    private Boolean isDoctor;
}
