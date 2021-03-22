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
	
	 public Patient getPatientById(long id);
	 
	 @Query(value="Select m.id from Patient m where m.nom= :nom " , nativeQuery=true)
		public long getIdPatient(@Param("nom") String nom);
	 
	 @Query(value="Select * from Patient m where m.id_user= :id " , nativeQuery=true)
	 public Patient getPatientByIduser(@Param("id")long id);
	 
	 @Query(value="Select * from  Patient p , demand_rdv m  where p.id = m.ID_Patient and m.etat = 0" , nativeQuery=true)
		public List<Patient> getlstPatient();

}
