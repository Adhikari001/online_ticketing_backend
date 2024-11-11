package com.example.onlineticketing.dto.role;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class AddRoleRequest {
    @NotNull(message = "Role name is required")
    private String roleName;
    @NotNull(message = "Authorities are required")
    private Set<Long> authorities;
}
