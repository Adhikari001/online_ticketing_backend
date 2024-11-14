
package com.example.onlineticketing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.onlineticketing.constant.routes.Routes;
import com.example.onlineticketing.dto.authenticate.AuthenticationRequest;
import com.example.onlineticketing.dto.person.AuthenticateRequest;
import com.example.onlineticketing.dto.person.AuthenticationResponse;
import com.example.onlineticketing.service.person.PersonService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationController.class);
    private final PersonService personService;

    @PostMapping(Routes.AUTHENTICATE)
    public AuthenticationResponse postMethodName(@Valid @RequestBody AuthenticateRequest request) {
        LOG.info("authenticate user {}", request);
        return personService.authenticateUser(request);
    }

}
