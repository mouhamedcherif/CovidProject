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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.esprit.covid.model.Medecin;
import com.esprit.covid.model.Recherche;
import com.esprit.covid.model.User;
import com.esprit.covid.repository.MedecinRepository;
import com.esprit.covid.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/covid")
public class MedecinRest {

	@Autowired
	private MedecinRepository medecinRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/Medecin")
	public List<Medecin> getAllEmployees() {
		return medecinRepository.findAll();
	}

	@GetMapping("/Medecin/{id}")
	public ResponseEntity<Medecin> getUserById(@PathVariable(value = "id") Long MedecinId) throws Exception{
		Medecin medecin = null;
		medecin = medecinRepository.findById(MedecinId).orElseThrow(() -> new Exception("User not found for this id :: " + MedecinId));
		return ResponseEntity.ok().body(medecin);	

	}
// modifier la recuperation des donneés avec @params 
	@PostMapping("/medecins")
	public Medecin createmedecins(@Valid @RequestBody Medecin medecin ,@RequestParam(value ="iduser") Long UsertId) {
		User user = userRepository.getUserById(UsertId);
		medecin.setUser(user);

			//a complete le test 
			return medecinRepository.save(medecin);
			 
	}

	@PutMapping("/Medecinsput/{id}")
	public ResponseEntity<Medecin> updatemedecins(@PathVariable(value = "id") Long MedecinId,
			@Valid @RequestBody Medecin MedecinDetails) throws Exception {
		Medecin medecin = medecinRepository.findById(MedecinId)
				.orElseThrow(() -> new Exception("User not found for this id :: " + MedecinId));
		medecin.setNom(MedecinDetails.getNom());
		medecin.setPrenom(MedecinDetails.getPrenom());
		medecin.setCin(MedecinDetails.getCin());
		medecin.setSepc(MedecinDetails.getSepc());
		medecin.setSex(MedecinDetails.getSex());
		final Medecin updatedMedecin = medecinRepository.save(medecin);
		return ResponseEntity.ok(updatedMedecin);
	}

	@DeleteMapping("/Medecinsdel/{id}")
	public Map<String, Boolean> deletemedecins(@PathVariable(value = "id") Long medecinId)
			throws Exception {
		Medecin  medecin= medecinRepository.findById(medecinId)
				.orElseThrow(() -> new Exception("Employee not found for this id :: " + medecinId));

		medecinRepository.delete(medecin);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@PostMapping(path = "/Medecins/recherchec")
	public List<Medecin>  recherche(Recherche objectKey ,@RequestParam(value ="spec") String  spec,
									@RequestParam(value ="pseudo") String  pseudo,
									@RequestParam(value ="cin") String  cin,
									@RequestParam(value ="sex") String  sex) throws Exception {
		/* récupérer les médecins correpondants role sélectionnée */
		List<Medecin> listmed = null;
			listmed = medecinRepository.Search(objectKey.getSpec(), 
											   objectKey.getPseudo(), 
											   objectKey.getCin(), 
											   objectKey.getSex());
			if (listmed.isEmpty()) 	throw  new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "this medcin not found");

		/* charger la liste de l'objet res  */
		return listmed;

		
	}
}
