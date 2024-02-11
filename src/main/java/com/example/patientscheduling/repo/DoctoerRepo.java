package com.example.patientscheduling.repo;

import com.example.patientscheduling.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctoerRepo extends JpaRepository<Doctor, Long> {
}
