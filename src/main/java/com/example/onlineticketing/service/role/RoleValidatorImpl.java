package com.example.onlineticketing.service.role;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.onlineticketing.comms.exceptionhandler.RestException;
import com.example.onlineticketing.entity.person.Role;
import com.example.onlineticketing.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleValidatorImpl implements RoleValidator {
    private final RoleRepository roleRepository;

    @Override
    public Role validateRole(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElseThrow(
                () -> new RestException("RV001", "Can not find role from the given id"));
    }

}
