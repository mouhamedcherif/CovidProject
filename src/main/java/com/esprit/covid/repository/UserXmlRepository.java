package com.esprit.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.covid.model.User;
import com.esprit.covid.model.UserXml;

public interface UserXmlRepository extends JpaRepository<UserXml, Long>{
	public List<UserXml> findByRole(String spec);

}
