package com.example.onlineticketing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.onlineticketing.constant.routes.Routes;
import com.example.onlineticketing.dto.patient.AddVisitRequest;
import com.example.onlineticketing.dto.util.MessageResponse;
import com.example.onlineticketing.service.patient.PatientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PatientsController {
    private final PatientService patientService;

    @PostMapping(Routes.PATIENT_ADD_VISIT_REQUEST)
    public MessageResponse addPatientVisitRequest(@Valid @RequestBody AddVisitRequest request) {
        log.info("Add patient complaint request {}", request);
        return patientService.addPatientVisitRequest(request);
    }

}
