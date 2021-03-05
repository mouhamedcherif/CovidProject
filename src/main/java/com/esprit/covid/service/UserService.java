package com.esprit.covid.service;

import java.util.List;

import com.esprit.covid.model.User;


public interface UserService {
	
	 public List<User> getAllMedecins();
 	 
	 public User getMedecinById(long id);
	  
	 public void saveOrUpdate(User med);
	 
	 public void deleteMedecin(long id);
	 
	 public List<User> findByRole(String spec);
	 
	public List<User> Search(String spec, String pseudo);

}
