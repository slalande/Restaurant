package com.adaming.restaurant.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.restaurant.entity.Plat;
import com.adaming.restaurant.service.PlatService;
@CrossOrigin
@RestController
@RequestMapping(value="/PlatRest")
public class PlatRestController {
	
	@Autowired
	private PlatService pserv;
	
	public PlatService getPserv() {
		return pserv;
	}

	public void setPserv(PlatService pserv) {
		this.pserv = pserv;
	}

	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
//	public ResponseEntity<Object> AjoutPlat(@RequestBody Plat p) {
//		pserv.AjoutPlatService(p);
//		return new ResponseEntity<Object>("Plat ajouté avec succès", HttpStatus.OK);
		public void AjoutPlat(@RequestBody Plat p) {
			pserv.AjoutPlatService(p);
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public ResponseEntity<Object> SupprimerPlat(@RequestBody Plat p) {
		pserv.SupprimerplatService(p);
		return new ResponseEntity<Object>("Plat supprimé avec succès", HttpStatus.OK);
	}
	
	@RequestMapping(value="/ByID/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> GetPlatByID(@PathVariable("id") String id) {
		return new ResponseEntity<Object>("Le plat est :" + pserv.GetPlatByID(Long.parseLong(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value="/All", method=RequestMethod.GET)
//	public ResponseEntity<Object> getAllPlat() {
//		return new ResponseEntity<Object>("Les plas sont :" + pserv.GetAllPlat(), HttpStatus.OK);
	public List<Plat> getAllPlat() {
		return pserv.GetAllPlat();
	}
	
	@RequestMapping(value="/SupByID/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<Object> SupClientByID(@PathVariable("id") String id, @RequestBody Plat pl) {
//		pserv.SupPlatByID(Long.parseLong(id));
//		return new ResponseEntity<Object>("Plat supprimé avec succès", HttpStatus.OK);
		public void SupPlatByID(@PathVariable("id") String id) {
			pserv.SupPlatByID(Long.parseLong(id));
	}
	
	

}
