package com.esprit.covid.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.esprit.covid.model.Medecin;
import com.esprit.covid.model.Patient;
import com.esprit.covid.model.RecherchePatient;
import com.esprit.covid.model.User;
import com.esprit.covid.repository.PatientRepository;
import com.esprit.covid.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/covid")
public class PatientRest {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/Patient")
	public List<Patient> getAllEmployees() {
		return patientRepository.findAll();
	}

	@GetMapping("/Patient/{id}")
	public ResponseEntity<Patient> getUserById(@PathVariable(value = "id") Long MedecinId) throws Exception{
		Patient Patient = null;
		Patient = patientRepository.findById(MedecinId).orElseThrow(() -> new Exception("User not found for this id :: " + MedecinId));
		return ResponseEntity.ok().body(Patient);	

	}

	@PostMapping("/Patients/{email}/{mdp}")
	public Medecin createmedecins(@Valid @RequestBody Patient Patient ,@PathVariable("email") String  email,@PathVariable("mdp") String  mdp) {
			User user = userRepository.checkloginpation( email, mdp);
			if(!user.equals(null)) {
				Patient.setUser(user);
			}
			//a compléte le test 
			patientRepository.save(Patient);
			return null;
	}

	@PutMapping("/Patientsput/{id}")
	public ResponseEntity<Patient> updatemedecins(@PathVariable(value = "id") Long PatientId,
			@Valid @RequestBody Patient PatientDetails) throws Exception {
		Patient patient = patientRepository.findById(PatientId)
				.orElseThrow(() -> new Exception("User not found for this id :: " + PatientId));
		patient.setNom(PatientDetails.getNom());
		patient.setPrenom(PatientDetails.getPrenom());
		patient.setCin(PatientDetails.getCin());
		patient.setAge(PatientDetails.getAge());
		patient.setSex(PatientDetails.getSex());
		patient.setNumcnss(PatientDetails.getNumcnss());
		final Patient updatedMedecin = patientRepository.save(patient);
		return ResponseEntity.ok(updatedMedecin);
	}

	@DeleteMapping("/Patientsdel/{id}")
	public Map<String, Boolean> deletemedecins(@PathVariable(value = "id") Long patientId)
			throws Exception {
		Patient Patient  = patientRepository.findById(patientId)
				.orElseThrow(() -> new Exception("Employee not found for this id :: " + patientId));

		patientRepository.delete(Patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@PostMapping(path = "/Patients/recherchec")
	public List<Patient>  recherche(RecherchePatient objectKey,
									@RequestParam(value ="pseudo") String  pseudo,
									@RequestParam(value ="cin") String  cin,
									@RequestParam(value ="sex") String  sex,
									@RequestParam(value ="region") String  region) throws Exception {
		/* récupérer les médecins correpondants role sélectionnée */
		List<Patient> listmed = null;
			listmed = patientRepository.Search(objectKey.getPseudo(), 
											   objectKey.getCin(), 
											   objectKey.getSex(),
											   objectKey.getRegion());
			if (listmed.isEmpty()) 	throw  new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "this medcin not found");

		/* charger la liste de l'objet res  */
		return listmed;

		
	}
}
