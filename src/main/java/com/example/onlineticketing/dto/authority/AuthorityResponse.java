package com.example.onlineticketing.dto.authority;

import lombok.Data;

@Data
public class AuthorityResponse {
    private Long id;
    private String name;

    public AuthorityResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
