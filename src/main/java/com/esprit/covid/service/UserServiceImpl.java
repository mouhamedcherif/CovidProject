package com.esprit.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.covid.model.User;
import com.esprit.covid.repository.UserRepository;

public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository agent;

	@Override
	public List<User> getAllMedecins() {
		// TODO Auto-generated method stub
		return agent.findAll();
	}

	@Override
	public User getMedecinById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(User med) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMedecin(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findByRole(String spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> Search(String spec, String pseudo) {
		// TODO Auto-generated method stub
		return null;
	}

}
