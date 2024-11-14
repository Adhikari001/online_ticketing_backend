package com.example.onlineticketing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.onlineticketing.constant.routes.Routes;
import com.example.onlineticketing.dto.util.ValueLabelDropdown;
import com.example.onlineticketing.service.role.RoleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping(Routes.ROLE_GET_ALL)
    public ValueLabelDropdown getMethodName() {
        return roleService.getRoleDropdown();
    }

}
