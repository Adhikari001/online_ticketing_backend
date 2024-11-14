package com.example.onlineticketing.service.role;

import org.springframework.stereotype.Service;

import com.example.onlineticketing.dto.util.ValueLabelDropdown;
import com.example.onlineticketing.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public ValueLabelDropdown getRoleDropdown() {
        return roleRepository.roleValueLabel();
    }

}
