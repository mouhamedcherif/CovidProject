package com.esprit.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.covid.model.Hopital;

public interface HopitalRepository extends JpaRepository<Hopital, Long>{

}
