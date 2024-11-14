package com.example.onlineticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlineticketing.entity.patient.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
