package com.example.onlineticketing.service.patient;

import com.example.onlineticketing.dto.patient.AddVisitRequest;
import com.example.onlineticketing.dto.util.MessageResponse;

public interface PatientService {

    MessageResponse addPatientVisitRequest(AddVisitRequest request);

}
