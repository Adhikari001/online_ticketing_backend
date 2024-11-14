package com.example.onlineticketing.entity.patient;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.onlineticketing.entity.person.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "added_date")
    private LocalDateTime addedDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "visit_status")
    private String visitStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointed_doctor", referencedColumnName = "id")
    private Person appointedDoctor;
}
