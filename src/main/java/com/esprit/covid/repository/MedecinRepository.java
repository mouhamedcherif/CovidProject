package com.esprit.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.covid.model.Medecin;
import com.esprit.covid.model.User;

public interface MedecinRepository extends JpaRepository<Medecin, Long>{
	
//	public List<User> findByRole(String spec);
	
	@Query(value="Select * from Medecin m where m.sepc = :spec or ( m.nom Like :pseudo or m.prenom Like :pseudo) "
			+ "or m.cin = :cin or m.sex = :sex", nativeQuery=true)
	public List<Medecin> Search(@Param("spec") String spec,@Param("pseudo") String pseudo,@Param("cin") String cin,
			@Param("sex") String sex);
	
	 public Medecin getMedecinById(long id);

//	public List<Medecin> findBySpecOrNomOrPernomOrCinOrSex( String spec, String pseudo,String cin,String sex);

	 @Query(value="Select m.id from Medecin m where m.nom= :nom " , nativeQuery=true)
		public long getIdmedecin(@Param("nom") String nom);
//
}
