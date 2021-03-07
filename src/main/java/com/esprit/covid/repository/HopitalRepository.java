package com.esprit.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.covid.model.Hopital;
import com.esprit.covid.model.Medecin;

public interface HopitalRepository extends JpaRepository<Hopital, Long>{
	
	@Query(value="Select * from Hopital m where m.id_medecin = :idmedecin ", nativeQuery=true)
	public List<Hopital> SearchMedecin(@Param("idmedecin") long idmedecin);
	
	@Query(value="Select * from Hopital m where m.id_patient = :idpatient ", nativeQuery=true)
	public List<Hopital> SearchPatient(@Param("idpatient") long idpatient);
	
	@Query(value="Select * from Hopital m where m.date_rv = :daterv or  m.etatest = :etatest or m.gouvernerat Like :gouvernerat "
			+ "or m.nom_hopital = :nomhopital or m.id_medecin = :idMedecin or m.id_patient = :idPatient ", nativeQuery=true)
	public List<Hopital> Searchmultiple(@Param("daterv") String daterv,@Param("etatest") String etatest,@Param("gouvernerat") String gouvernerat,
			@Param("nomhopital") String nomhopital,@Param("idMedecin") long idMedecin,@Param("idPatient") long idPatient);
}
