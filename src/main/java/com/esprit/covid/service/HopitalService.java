package com.esprit.covid.service;

import java.util.List;
import com.esprit.covid.model.Hopital;

public interface HopitalService {
	 public List<Hopital> getAllHopitals();
	 
	 public Hopital getHopitaltById(long id);
	  
	 public void saveOrUpdate(Hopital hopital);
	 
	 public void deleteHopital(long id);
}
