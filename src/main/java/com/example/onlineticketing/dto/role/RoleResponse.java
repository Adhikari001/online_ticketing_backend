package com.example.onlineticketing.dto.role;

import com.example.onlineticketing.dto.authority.AuthorityResponse;
import com.example.onlineticketing.entity.person.Role;
import lombok.Data;

import java.util.List;

@Data
public class RoleResponse {
    private Long id;
    private String name;
    private List<AuthorityResponse> authorities;

    public RoleResponse(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.authorities = role.getGrantedAuthorities().stream().map(auth->new AuthorityResponse(auth.getId(),auth.getName())).toList();
    }
}
