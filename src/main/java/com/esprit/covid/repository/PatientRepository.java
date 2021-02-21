package com.esprit.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.covid.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
