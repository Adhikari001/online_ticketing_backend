package com.example.onlineticketing.dto.person;

import com.example.onlineticketing.comms.validator.PasswordMatches;
import com.example.onlineticketing.comms.validator.ValidatePassword;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@PasswordMatches
@ToString(exclude = {"password", "confirmPassword"}, callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AddPersonRequest extends UpdatePersonRequest{
    @NotNull(message = "password can not be null")
    @NotEmpty(message = "password can not be empty")
    @ValidatePassword
    private String password;

    @NotNull(message= "confirm password can not be null")
    @NotEmpty(message = "confirm password can not be empty")
    private String confirmPassword;
}
