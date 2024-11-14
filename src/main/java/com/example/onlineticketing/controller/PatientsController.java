package com.example.onlineticketing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.onlineticketing.constant.routes.Routes;
import com.example.onlineticketing.dto.patient.AddVisitRequest;
import com.example.onlineticketing.dto.util.MessageResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PatientsController {
    @PostMapping(Routes.PATIENT_ADD_VISIT_REQUEST)
    public MessageResponse postMethodName(@Valid @RequestBody AddVisitRequest request) {

        return new MessageResponse("Bholi garne");
    }

}
