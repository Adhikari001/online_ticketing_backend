package com.example.onlineticketing.dto.person;

import com.example.onlineticketing.dto.role.RoleResponse;
import com.example.onlineticketing.entity.person.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class UserInformation {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String gender;
    private RoleResponse role;
    @JsonProperty("isActive")
    private boolean isActive;

    public UserInformation(Long id,
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
            String gender,
            Role role,
            boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.role = new RoleResponse(role);
        this.isActive = isActive;
    }

    public UserInformation(Long id,
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
            String gender,
            RoleResponse role,
            boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.role = role;
        this.isActive = isActive;
    }
}
