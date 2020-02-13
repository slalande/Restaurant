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

import com.adaming.restaurant.entity.Client;
import com.adaming.restaurant.service.ClientService;
@CrossOrigin
@RestController
@RequestMapping(value="/ClientRest")
public class ClientRestController {
	
	@Autowired
	private ClientService cserv;

	public ClientService getCserv() {
		return cserv;
	}

	public void setCserv(ClientService cserv) {
		this.cserv = cserv;
	}
	
	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
//	public ResponseEntity<Object> AjoutClient(@RequestBody Client cl) {
//		cserv.AjoutClientService(cl);
//		return new ResponseEntity<Object>("Client ajouté avec succès", HttpStatus.OK);
	public void AjoutClient(@RequestBody  Client cl) {
		cserv.AjoutClientService(cl);
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public ResponseEntity<Object> SupprimerClient(@RequestBody Client cl) {
		cserv.SupprimerClientService(cl);
		return new ResponseEntity<Object>("Client supprimé avec succès", HttpStatus.OK);
	}
	
	@RequestMapping(value="/ByID/{id}", method=RequestMethod.GET)
//	public ResponseEntity<Object> GetClientByID(@PathVariable("id") String id) {
//		return new ResponseEntity<Object>("Le client est :" + cserv.GetClientByIDService(Long.parseLong(id)), HttpStatus.OK);
	public Client GetClientByID(@PathVariable("id") String id) {
		return cserv.GetClientByIDService(Long.parseLong(id));
	}
	
	
	@RequestMapping(value="/All", method=RequestMethod.GET)
//	public ResponseEntity<Object> getAllClient() {
//		return new ResponseEntity<Object>("Les clients sont :" + cserv.GetAllClient(), HttpStatus.OK);
	public List<Client> findAllClient() {
		return cserv.GetAllClient();
	}
	
	@RequestMapping(value="/SupByID/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<Object> SupClientByID(@PathVariable("id") String id, @RequestBody Client cl) {
//		cserv.SupClientByIDService(Long.parseLong(id));
//		return new ResponseEntity<Object>("Client supprimé avec succès", HttpStatus.OK);
	public void SupClientByID(@PathVariable("id") String id) {		
		cserv.SupClientByIDService(Long.parseLong(id));;
	}
	
	

}
