package com.adaming.restaurant.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.restaurant.entity.Role;
import com.adaming.restaurant.service.RoleService;

@RestController
@RequestMapping(value="/RoleRest")
public class RoleRestController {
	
	@Autowired
	private RoleService rserv;
	
	public RoleService getRserv() {
		return rserv;
	}

	public void setRserv(RoleService rserv) {
		this.rserv = rserv;
	}

	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
	public ResponseEntity<Object> AjoutRole(@RequestBody Role r) {
		rserv.ajoutRoleService(r);
		return new ResponseEntity<Object>("Role ajouté avec succès", HttpStatus.OK);
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public ResponseEntity<Object> SupprimerRole(@RequestBody Role r) {
		rserv.supprimerRoleService(r);
		return new ResponseEntity<Object>("Role supprimé avec succès", HttpStatus.OK);
	}
	
	@RequestMapping(value="/ByID/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> GetRoleByID(@PathVariable("id") String id) {
		return new ResponseEntity<Object>("Le role est :" + rserv.rechercheRoleIDService(Long.parseLong(id)), HttpStatus.OK);
	}
	
//	@RequestMapping(value="/SupByID/{id}", method=RequestMethod.POST)
//	public ResponseEntity<Object> SupClientByID(@PathVariable("id") String id, @RequestBody Client cl) {
//		cserv.SupClientByIDService(Long.parseLong(id));
//		return new ResponseEntity<Object>("Client supprimé avec succès", HttpStatus.OK);
//	}
	
	

}
