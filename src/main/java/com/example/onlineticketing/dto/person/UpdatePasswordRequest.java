package com.example.onlineticketing.dto.person;

import com.example.onlineticketing.comms.validator.PasswordMatches;
import com.example.onlineticketing.comms.validator.ValidatePassword;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;


@Data
@PasswordMatches
@ToString(exclude = {"oldPassword", "newPassword", "confirmPassword"}, callSuper = true)
public class UpdatePasswordRequest {
    @NotNull(message = "Old password is required")
    @NotEmpty(message = "password can not be empty")
    private String oldPassword;

    @NotNull(message = "New password is required")
    @NotEmpty(message = "password can not be empty")
    @ValidatePassword
    private String newPassword;

    @NotNull(message = "Confirm password is required")
    @NotEmpty(message = "password can not be empty")
    private String confirmPassword;
}
