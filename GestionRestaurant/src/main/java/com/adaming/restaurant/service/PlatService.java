package com.adaming.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.restaurant.dao.IPlatDAO;
import com.adaming.restaurant.entity.Plat;

@Service
public class PlatService {
	
	@Autowired
	private IPlatDAO daoplat;

	public IPlatDAO getDaoplat() {
		return daoplat;
	}

	public void setDaoplat(IPlatDAO daoplat) {
		this.daoplat = daoplat;
	}
	
	public void AjoutPlatService(Plat p) {
		daoplat.save(p);
	}
	
	public void SupprimerplatService(Plat p) {
		daoplat.delete(p);
	}
	
	public void MAJPlatService(Plat p) {
		daoplat.saveAndFlush(p);
	}
	
	public List<Plat> GetAllPlat() {
		return daoplat.findAll();
	}
	
	public Plat GetPlatByID(long id) {
		return daoplat.getOne(id);
	}
	
	public void SupPlatByID(long id) {
		daoplat.deleteById(id);
	}

}
