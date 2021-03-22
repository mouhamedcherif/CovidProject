package com.esprit.covid.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.covid.model.DemandRdv;
import com.esprit.covid.model.Hopital;
import com.esprit.covid.model.Medecin;
import com.esprit.covid.model.Patient;

public interface RdvRepository extends JpaRepository<DemandRdv, Long>{
	 
	 @Query(value="Select * from demand_rdv m where m.ID_Patient= :id " , nativeQuery=true)
	public DemandRdv getPATIENTById(long id);
	 @Modifying
	 @Transactional
	 @Query(value="INSERT INTO demand_rdv (etat,id_hopital, id_medecin,id_patient) VALUES (0,null,null,:id)" , nativeQuery=true)
	public void insertRdv(@Param("id") long id);
	 
	 @Query(value="Select * from medecin m where m.id= :id " , nativeQuery=true)
	 public Medecin getMedecinById(long id);
	 
	 @Query(value="Select * from patient m where m.id= :id " , nativeQuery=true)
	 public Patient getpatientById(long id);
	 
	 @Query(value="Select * from hopital m where m.id= :id " , nativeQuery=true)
	 public Hopital gethopitalById(long id);

	@Query(value="Select * from demand_rdv m where m.id_patient = :idpatient ", nativeQuery=true)
	public List<DemandRdv> SearchPatient(@Param("idpatient") long idpatient);
	
	 @Query(value="Select * from demand_rdv m where m.id_hopital= :id " , nativeQuery=true)
	public DemandRdv getHopitalById(long id);

}
