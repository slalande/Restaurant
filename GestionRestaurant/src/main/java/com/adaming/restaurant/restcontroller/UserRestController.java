package com.adaming.restaurant.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.restaurant.entity.User;
import com.adaming.restaurant.service.UserService;

@RestController
@RequestMapping(value="/UserRest")
public class UserRestController {
	
	@Autowired
	private UserService userv;
	
	public UserService getUserv() {
		return userv;
	}

	public void setUserv(UserService userv) {
		this.userv = userv;
	}

	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
	public ResponseEntity<Object> AjoutUser(@RequestBody User u) {
		userv.ajoutUserService(u);
		return new ResponseEntity<Object>("User ajouté avec succès", HttpStatus.OK);
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public ResponseEntity<Object> SupprimerUser(@RequestBody User u) {
		userv.supprimerUserService(u);
		return new ResponseEntity<Object>("User supprimé avec succès", HttpStatus.OK);
	}
	
	@RequestMapping(value="/ByID/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> GetUserByID(@PathVariable("id") String id) {
		return new ResponseEntity<Object>("Le user est :" + userv.rechercheUserIDService(Long.parseLong(id)), HttpStatus.OK);
	}
	
//	@RequestMapping(value="/SupByID/{id}", method=RequestMethod.POST)
//	public ResponseEntity<Object> SupClientByID(@PathVariable("id") String id, @RequestBody Client cl) {
//		cserv.SupClientByIDService(Long.parseLong(id));
//		return new ResponseEntity<Object>("Client supprimé avec succès", HttpStatus.OK);
//	}
//	
	

}
