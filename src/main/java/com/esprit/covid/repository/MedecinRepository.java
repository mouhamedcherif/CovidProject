package com.esprit.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.covid.model.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long>{

}
