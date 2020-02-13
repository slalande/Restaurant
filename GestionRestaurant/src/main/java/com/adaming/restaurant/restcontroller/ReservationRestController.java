package com.adaming.restaurant.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.restaurant.entity.Reservation;
import com.adaming.restaurant.service.ReservationService;

@RestController
@RequestMapping(value="/ReservationRest")
public class ReservationRestController {
	
	@Autowired
	private ReservationService rserv;
	
	public ReservationService getRserv() {
		return rserv;
	}

	public void setRserv(ReservationService rserv) {
		this.rserv = rserv;
	}

	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
//	public ResponseEntity<Object> AjoutReservation(@RequestBody Reservation r) {
//		rserv.AjoutReservationService(r);
//		return new ResponseEntity<Object>("Reservation ajouté avec succès", HttpStatus.OK);
	public void AjoutReservation(@RequestBody Reservation r) {
		rserv.AjoutReservationService(r);
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public ResponseEntity<Object> SupprimerReservation(@RequestBody Reservation r) {
		rserv.SupprimerReservationService(r);
		return new ResponseEntity<Object>("Reservation supprimé avec succès", HttpStatus.OK);
	}
	
	@RequestMapping(value="/ByID/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> GetReservationByID(@PathVariable("id") String id) {
		return new ResponseEntity<Object>("La Reservation est :" + rserv.GetResByID(Long.parseLong(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value="/All", method=RequestMethod.GET)
//	public ResponseEntity<Object> getAllReservation() {
//		return new ResponseEntity<Object>("Les reservations sont :" + rserv.GetAllResService(), HttpStatus.OK);
	public List<Reservation> getAllReservation() {
		return rserv.GetAllResService();
	}
	
	@RequestMapping(value="/SupByID/{id}", method=RequestMethod.POST)
//	public ResponseEntity<Object> SupReservationByID(@PathVariable("id") String id, @RequestBody Reservation r) {
//		rserv.SupResByID(Long.parseLong(id));
//		return new ResponseEntity<Object>("Réservation supprimée avec succès", HttpStatus.OK);
		public void SupReservationByID(@PathVariable("id") String id, @RequestBody Reservation r) {
			rserv.SupResByID(Long.parseLong(id));
	}
	
	

}
