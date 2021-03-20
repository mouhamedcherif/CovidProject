package com.esprit.covid.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.esprit.covid.model.User;
import com.esprit.covid.repository.UserRepository;
import com.esprit.covid.service.UserService;


@RestController
@RequestMapping("/api/covid")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRest {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/User")
	public List<User> getAllEmployees() {
		return userRepository.findAll();
	}

	@GetMapping("/User/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long UserId) throws Exception{
		User user = null;
			user = userRepository.findById(UserId).orElseThrow(() -> new Exception("User not found for this id :: " + UserId));
		return ResponseEntity.ok().body(user);	

	}

	@PostMapping("/Users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/Usersput/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long UserId,
			@Valid @RequestBody User UserDetails) throws Exception {
		User user = userRepository.findById(UserId)
				.orElseThrow(() -> new Exception("User not found for this id :: " + UserId));
		//user.setId(UserDetails.getId());
		user.setEmail(UserDetails.getEmail());
		user.setMdp(UserDetails.getMdp());
		user.setRoler(UserDetails.getRoler());
		final User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/Usersdel/{id}")
	public Map<String, Boolean> deleteUsers(@PathVariable(value = "id") Long UserId)
			throws Exception {
		User user = userRepository.findById(UserId)
				.orElseThrow(() -> new Exception("Employee not found for this id :: " + UserId));

		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@GetMapping("/User/recherche/{spec}")
	public List<User>  recherche(@PathVariable("spec") String  res) throws Exception {		
		/* récupérer les médecins correpondants role sélectionnée */
		List<User> listmed = null;
			listmed = userRepository.findByRoler(res);
			if (listmed.isEmpty()) 	throw  new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "this role not found");

		/* charger la liste de l'objet res  */
		return listmed;

		
	}
	@RequestMapping("/Userlogin")
	public Map<String, String> isLogin(@RequestParam(value = "email") String email ,
									@RequestParam(value = "mdp") String mdp )
			throws Exception {
		String token = "";
		User user = userRepository.checklogin(email , mdp);
		if( user != null ) {
			Integer nb;
			long v = ThreadLocalRandom.current().nextLong(100000,900000); // For 2-digit integers, 10-99 inclusive.
			System.out.println(v);
			token = Long.toString(v);
		}	

		Map<String, String> response = new HashMap<>();
		response.put("id", Long.toString(user.getId()) );
		response.put("token", token);
		response.put("role", user.getRoler());

		return response;
	}
}
