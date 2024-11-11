//package com.example.onlineticketing.dto.person;
//
//
//
//import com.example.onlineticketing.comms.validator.PasswordMatches;
//import com.example.onlineticketing.comms.validator.ValidEmail;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
//import lombok.Getter;
//import lombok.Setter;
//
//
//
//@Getter
//@Setter
//@PasswordMatches
//public class UserDto {
//    @NotNull(message = "First name can not be empty")
//    @NotEmpty(message = "First name can not be empty")
//    private String firstName;
//
//    @NotNull(message = "Last name can not be empty")
//    @NotEmpty(message = "Last name can not be empty")
//    private String lastName;
//
//    @NotNull(message = "Password can not be empty")
//    @NotEmpty(message = "Password can not be empty")
//    private String password;
//
//    @NotNull(message = "Confirm password can not be empty")
//    @NotEmpty(message = "Confirm password can not be empty")
//    private String matchingPassword;
//
//    @ValidEmail(message = "Provided email is not valid")
//    @NotNull(message = "Email can not be empty")
//    @NotEmpty(message = "Email can not be empty")
//    private String email;
//
//    public UserDto() {
//        this.firstName = "Saurav";
//        this.lastName = "Adhikari";
//        this.password = "Saurav@123";
//        this.matchingPassword = "Saurav@123";
//        this.email = "saurav@saurav.com";
//    }
//}