package com.example.onlineticketing.service.patient;

import static java.lang.annotation.ElementType.PACKAGE;

import org.springframework.stereotype.Service;

import com.example.onlineticketing.comms.helper.EnumHelperUtil;
import com.example.onlineticketing.comms.helper.HelperUtil;
import com.example.onlineticketing.constant.enums.VisitStatus;
import com.example.onlineticketing.dto.patient.AddVisitRequest;
import com.example.onlineticketing.dto.util.MessageResponse;
import com.example.onlineticketing.entity.patient.Patient;
import com.example.onlineticketing.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public MessageResponse addPatientVisitRequest(AddVisitRequest request) {
        patientRepository.save(prepareToAddPatientVisit(request));
        return new MessageResponse("Request added successfully");
    }

    private Patient prepareToAddPatientVisit(AddVisitRequest request) {
        Patient patient = new Patient();
        patient.setFullName(request.getFullName());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setEmail(request.getEmail());
        patient.setGender(EnumHelperUtil.validateGender(
                request.getGender()).name());
        patient.setDateOfBirth(HelperUtil.toLocalDate(request.getDateOfBirth()));
        patient.setComplaint(request.getComplaint());
        patient.setVisitStatus(VisitStatus.REQUESTED.name());
        return patient;
    }

}
