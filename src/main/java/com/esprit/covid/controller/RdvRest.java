package com.esprit.covid.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.covid.model.DemandRdv;
import com.esprit.covid.model.Hopital;
import com.esprit.covid.model.Medecin;
import com.esprit.covid.model.Patient;
import com.esprit.covid.repository.HopitalRepository;
import com.esprit.covid.repository.MedecinRepository;
import com.esprit.covid.repository.PatientRepository;
import com.esprit.covid.repository.RdvRepository;

@RestController
@RequestMapping("/api/covid")
@CrossOrigin(origins = "http://localhost:4200")
public class RdvRest {
	@Autowired
	private RdvRepository rdvRepository;
	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private HopitalRepository hopitalRepository;
	@Autowired
	private MedecinRepository medecinRepository;
	
	@PostMapping("/demande/ajout")
	public void createrendv(@RequestParam(value ="idPatient") long  idPatient)  {
			//a complete le test 
			 rdvRepository.insertRdv(idPatient);
		
	}
	@GetMapping("/etat")
	public List<DemandRdv> getrendvByIdpatient(@RequestParam(value ="idPatient") Long idpatient) throws Exception{
		List<DemandRdv> demandRdvs = null;
		demandRdvs = rdvRepository.SearchPatient(idpatient);
		return demandRdvs;	
	}
	public void updaterendv(Long HopitalId, long id_patient , long id_MEDECIN) throws Exception {
		
		Medecin med = rdvRepository.getMedecinById(id_MEDECIN);
		Patient patient = rdvRepository.getpatientById(id_patient);
		Hopital hopital = rdvRepository.gethopitalById(HopitalId);

		DemandRdv demandRdv = new DemandRdv();
		demandRdv = rdvRepository.getPATIENTById(id_patient);
		
		if(demandRdv != null) {
			demandRdv.setHopital(hopital);
			demandRdv.setMedecin(med);
			demandRdv.setPatient(patient);
			//affectation demande
			demandRdv.setEtat(1);
		}
		
		rdvRepository.save(demandRdv);

	}
	@GetMapping("/demande")
	public List<DemandRdv> getAllErendv() {
		return rdvRepository.findAll();
	}
}
