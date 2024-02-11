package com.example.patientscheduling.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dockerId;
    private String doctorName;

    @ManyToMany(mappedBy = "doctors", fetch = FetchType.EAGER)
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<Appointment> appointments;
}
