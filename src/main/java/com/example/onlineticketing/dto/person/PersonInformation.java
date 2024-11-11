package com.example.onlineticketing.dto.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonInformation {
    private Long userId;
    private String fullName;
}
