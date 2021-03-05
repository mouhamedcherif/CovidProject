package com.esprit.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.covid.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public List<User> findByRole(String spec);
	
//	@Query(value="Select m from Medecin m where m.specialite = :spec "
//			+ "and ( m.nom Like :pseudo or m.prenom Like :pseudo)")
//	public List<Medecin> Search(@Param("spec") String s,
//			@Param("pseudo") String p);

}
