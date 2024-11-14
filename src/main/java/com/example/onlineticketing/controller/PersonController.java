package com.example.onlineticketing.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.example.onlineticketing.constant.routes.Routes;
import com.example.onlineticketing.dto.person.AddPersonRequest;
import com.example.onlineticketing.dto.person.UpdatePasswordRequest;
import com.example.onlineticketing.dto.person.UpdatePersonRequest;
import com.example.onlineticketing.dto.person.UserInformation;
import com.example.onlineticketing.dto.person.UserInformationResponse;
import com.example.onlineticketing.dto.util.MessageResponse;
import com.example.onlineticketing.dto.util.ValueLabelDropdown;
import com.example.onlineticketing.service.person.PersonService;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {
    static final Logger log = LoggerFactory.getLogger(PersonController.class);
    private final PersonService personService;

    @GetMapping(Routes.GET_AUTHENTICATED_PERSON)
    public UserInformation getUserInformation(Principal principal) {
        log.info("Get user information {}", principal.getName());
        return personService.getAuthenticatedUser(principal);
    }

    @GetMapping(Routes.GET_ALL_PERSON)
    public List<UserInformation> getAllPerson() {
        log.info("Get all person");
        return personService.getAllPerson();
    }

    @GetMapping(Routes.GET_DOCTOR_DROPDOWN)
    public List<ValueLabelDropdown> getDoctorDropdown() {
        log.info("Get doctor dropdown");
        return personService.getDoctorDropdown();
    }

    @PostMapping(Routes.ADD_PERSON)
    public MessageResponse addPerson(@Valid @RequestBody AddPersonRequest request) {
        log.info("Create person request {}", request);
        return personService.addPerson(request);
    }

    @PutMapping(Routes.UPDATE_PERSON)
    public MessageResponse updatePerson(@Valid @RequestBody UpdatePersonRequest request, @PathVariable Long userId) {
        log.info("Update person request {} {}", request, userId);
        return personService.updatePerson(request, userId);
    }

    @PostMapping(Routes.PERSON_LOGOUT)
    public MessageResponse logout() {
        log.info("Logout request");
        return new MessageResponse("Logged out successfully.");
    }

    @GetMapping(Routes.GET_PERSON_BY_ID)
    public UserInformation getPersonById(@PathVariable Long userId) {
        log.info("Get person detail by id {}", userId);
        return personService.getPersonDetail(userId);
    }

    @PostMapping(Routes.CHANGE_PASSWORD)
    public MessageResponse changePassword(@Valid @RequestBody UpdatePasswordRequest request) {
        log.info("Change password request {}", request);
        return personService.changePassword(request);
    }

}
