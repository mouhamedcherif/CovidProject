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

import com.esprit.covid.model.DemandRdv;
import com.esprit.covid.model.Hopital;
import com.esprit.covid.model.Medecin;
import com.esprit.covid.model.Patient;
import com.esprit.covid.model.RechercheRendv;
import com.esprit.covid.model.User;
import com.esprit.covid.repository.HopitalRepository;
import com.esprit.covid.repository.MedecinRepository;
import com.esprit.covid.repository.PatientRepository;
import com.esprit.covid.repository.RdvRepository;
import com.esprit.covid.repository.UserRepository;

@RestController
@RequestMapping("/api/covid")
@CrossOrigin(origins = "http://localhost:4200")
public class HopitalRest {
	@Autowired
	private MedecinRepository medecinRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private HopitalRepository hopitalRepository;
	
	@Autowired
	private RdvRepository rdvRepository;
	
	@GetMapping("/rendv")
	public List<Hopital> getAllErendv() {
		return hopitalRepository.findAll();
	}
	@GetMapping("/rendv/{id}")
	public ResponseEntity<Hopital> getrendvById(@PathVariable(value = "id") Long rendvnId) throws Exception{
		Hopital hopital = null;
		hopital = hopitalRepository.findById(rendvnId).orElseThrow(() -> new Exception("User not found for this id :: " + rendvnId));
		return ResponseEntity.ok().body(hopital);	
	}
	@GetMapping("/rendvpatient")
	public List<Hopital> getrendvByIdpatient(@RequestParam(value ="idPatient") Long idpatient) throws Exception{
		List<Hopital> hopital = null;
		hopital = hopitalRepository.SearchPatient(idpatient);
		return hopital;	
	}
	@GetMapping("/rendvMedecin")
	public List<Hopital> getrendvByIdMedecin(@RequestParam(value ="idMedecin") Long idmedecin) throws Exception{
		List<Hopital> hopital = null;
		hopital = hopitalRepository.SearchMedecin(idmedecin);
		return hopital;	
	}
	@PostMapping("/rendv/ajout")
	public Hopital createrendv(@Valid @RequestBody Hopital hopital ,
							   @RequestParam(value ="idMedecin") long  idMedecin,
							   @RequestParam(value ="idPatient") long  idPatient) throws Exception  {
		
			//User user = userRepository.checkloginAffectation( email, mdp);
					Medecin med = medecinRepository.getMedecinById(idMedecin);
					Patient patient = patientRepository.getPatientById(idPatient);
				
					if(!(med.equals(null) && patient.equals(null)) )
						hopital.setMedecin(med);
						hopital.setPatient(patient);
						
			
			//a complete le test 
			 hopitalRepository.save(hopital);
				DemandRdv demandRdv = new DemandRdv();

			  demandRdv = rdvRepository.getPATIENTById(idPatient);
				
				if(demandRdv != null) {
					demandRdv.setHopital(hopital);
					demandRdv.setMedecin(med);
					demandRdv.setPatient(patient);
					//affectation demande
					demandRdv.setEtat(1);
				}
				
			rdvRepository.save(demandRdv);
			 
			 return hopital;
	}
	@PutMapping("/rendvput/{id}")
	public ResponseEntity<Hopital> updaterendv(@PathVariable(value = "id") Long HopitalId,
			@Valid @RequestBody Hopital HopitalDetails) throws Exception {
		Hopital hopital = hopitalRepository.findById(HopitalId)
				.orElseThrow(() -> new Exception("User not found for this id :: " + HopitalId));
		
		hopital.setDateRv(HopitalDetails.getDateRv());
		hopital.setEtatest(HopitalDetails.getEtatest());
		hopital.setGouvernerat(HopitalDetails.getGouvernerat());
		hopital.setNomHopital(HopitalDetails.getNomHopital());
		
//		hopital.setMedecin(HopitalDetails.getMedecin());
//		hopital.setPatient(HopitalDetails.getPatient());
		final Hopital updatedRendv = hopitalRepository.save(hopital);
		return ResponseEntity.ok(updatedRendv);
	}
	@PutMapping("/rendvputmedecinaccept")
	public ResponseEntity<Hopital> updaterendv(@RequestParam(value = "id") Long HopitalId) throws Exception {
		Hopital hopital = hopitalRepository.findById(HopitalId)
				.orElseThrow(() -> new Exception("User not found for this id :: " + HopitalId));
		DemandRdv demandRdv = new DemandRdv();

		  demandRdv = rdvRepository.getHopitalById(HopitalId);
		  demandRdv.setEtat(2);

		final Hopital updatedRendv = hopitalRepository.save(hopital);
		return ResponseEntity.ok(updatedRendv);
	}
	@PutMapping("/rendvputmedecinrefuse/{id}")
	public ResponseEntity<Hopital> updaterendvrefuse(@RequestParam(value = "id") Long HopitalId) throws Exception {
		Hopital hopital = hopitalRepository.findById(HopitalId)
				.orElseThrow(() -> new Exception("User not found for this id :: " + HopitalId));
		DemandRdv demandRdv = new DemandRdv();

		  demandRdv = rdvRepository.getHopitalById(HopitalId);
		  //etat d'affectation
		  demandRdv.setEtat(1);

		final Hopital updatedRendv = hopitalRepository.save(hopital);
		return ResponseEntity.ok(updatedRendv);
	}
	@DeleteMapping("/rendvdel/{id}")
	public Map<String, Boolean> deleterendv(@PathVariable(value = "id") Long HopitalId)
			throws Exception {
		Hopital hopital= hopitalRepository.findById(HopitalId)
				.orElseThrow(() -> new Exception("Employee not found for this id :: " + HopitalId));

		hopitalRepository.delete(hopital);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@PostMapping(path = "/rendv/recherche")
	public List<Hopital>  recherche(RechercheRendv objectKey ,@RequestParam(value ="DateRv") String  DateRv,
									@RequestParam(value ="Etatest") String  Etatest,
									@RequestParam(value ="Gouvernerat") String  Gouvernerat,
									@RequestParam(value ="NomHopital") String  NomHopital,
									@RequestParam(value ="nomedecin") String  nomedecin,
									@RequestParam(value ="nompatient") String  nompatient) throws Exception {
		/* récupérer les médecins correpondants role sélectionnée */
		List<Hopital> listHopital = null;
		long idMedecin = 0;
		long idPatient = 0;
		if(!nomedecin.isEmpty()) {
			idMedecin = medecinRepository.getIdmedecin(nomedecin);
		}
		if(!nompatient.isEmpty()) {
			idPatient = patientRepository.getIdPatient(nompatient);

		}


		listHopital = hopitalRepository.Searchmultiple(objectKey.getDateRv(), 
				objectKey.getEtatest(), objectKey.getGouvernerat(), objectKey.getNomHopital(), idMedecin, idPatient);
		
			if (listHopital.isEmpty()) 	throw  new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "this medecin not found");

		/* charger la liste de l'objet res  */
		return listHopital;

		
	}
	
}
