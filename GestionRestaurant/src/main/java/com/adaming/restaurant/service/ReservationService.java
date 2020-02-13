package com.adaming.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.restaurant.dao.IReservationDAO;
import com.adaming.restaurant.entity.Reservation;

@Service
public class ReservationService {
	
	@Autowired
	private IReservationDAO daores;

	public IReservationDAO getDaores() {
		return daores;
	}

	public void setDaores(IReservationDAO daores) {
		this.daores = daores;
	}
	
	public void AjoutReservationService(Reservation r) {
		daores.save(r);
	}

	public void SupprimerReservationService(Reservation r) {
		daores.delete(r);
	}
	
	public void MAJReservationService(Reservation r) {
		daores.saveAndFlush(r);
	}
	
	public List<Reservation> GetAllResService() {
		return daores.findAll();
	}
	
	public Reservation GetResByID(long id) {
		return daores.getOne(id);
	}
	
	public void SupResByID(long id) {
		daores.deleteById(id);
	}
}
