package com.esprit.covid.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.esprit.covid.model.User;
import com.esprit.covid.model.UserXml;
import com.esprit.covid.repository.UserXmlRepository;

@RestController
@RequestMapping("/api/covid")
public class UserXmlRest {
	
	@Autowired
	private UserXmlRepository userXmlServ;
	
    @GetMapping(value="/Userxml", produces=MediaType.APPLICATION_XML_VALUE)
    public List<UserXml> findUserxml() {

        return userXmlServ.findAll();
    }
    
    
    @GetMapping(value="/Userxml/{id}", produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<UserXml> findUserxmlById(@PathVariable(value = "id") Long UserId) throws Exception {
    	UserXml user = null;
		user = userXmlServ.findById(UserId).orElseThrow(() -> new Exception("User not found for this id :: " + UserId));
	return ResponseEntity.ok().body(user);	
    }
    
	@PostMapping(value="/Usersxml", produces=MediaType.APPLICATION_XML_VALUE)
	public UserXml createUser(@Valid @RequestBody UserXml user) {
		return userXmlServ.save(user);
	}
	@PutMapping(value= "/Usersxmlput/{id}", produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<UserXml> updateUser(@PathVariable(value = "id") Long UserId,
			@Valid @RequestBody UserXml UserDetails) throws Exception {
		UserXml user = userXmlServ.findById(UserId)
				.orElseThrow(() -> new Exception("User not found for this id :: " + UserId));
//		user.setId(UserDetails.getId());
		user.setEmail(UserDetails.getEmail());
		user.setMdp(UserDetails.getMdp());
		user.setRole(UserDetails.getRole());
		final UserXml updatedUser = userXmlServ.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	@DeleteMapping(value="/Usersxmldel/{id}", produces=MediaType.APPLICATION_XML_VALUE)
	public Map<String, Boolean> deleteUsers(@PathVariable(value = "id") Long UserId)
			throws Exception {
		UserXml user = userXmlServ.findById(UserId)
				.orElseThrow(() -> new Exception("Employee not found for this id :: " + UserId));

		userXmlServ.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@GetMapping(value="/Usersxml/recherche/{spec}", produces=MediaType.APPLICATION_XML_VALUE)
	public List<UserXml>  recherche(@PathVariable("spec") String  res) throws Exception {		
		/* récupérer les médecins correpondants role sélectionnée */
		List<UserXml> listmed = null;
			listmed = userXmlServ.findByRole(res);
			if (listmed.isEmpty()) 	throw  new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "this role not found");

		/* charger la liste de l'objet res  */
		return listmed;
	}
}
