package com.esprit.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.covid.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query(value="Select * from Patient m where ( m.nom Like :pseudo or m.prenom Like :pseudo) "
			+ "or m.cin = :cin or m.sex = :sex or region =:region", nativeQuery=true)
	public List<Patient> Search(@Param("pseudo") String pseudo,@Param("cin") String cin,
			@Param("sex") String sex,@Param("region") String region);
}
