package com.example.onlineticketing.service.person;

import com.example.onlineticketing.dto.person.UserInformation;
import com.example.onlineticketing.dto.role.RoleResponse;
import com.example.onlineticketing.entity.person.Person;

public class UserHelper {
    public static UserInformation getUserInformation(Person user) {
        return UserInformation
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .gender(user.getGender())
                .role(new RoleResponse(user.getRole()))
                .isActive(user.isActive())
                .build();
    }
}
