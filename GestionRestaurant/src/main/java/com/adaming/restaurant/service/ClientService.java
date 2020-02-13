package com.adaming.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.restaurant.dao.IClientDAO;
import com.adaming.restaurant.entity.Client;

@Service
public class ClientService {
	
	@Autowired
	private IClientDAO daocl;

	
	public IClientDAO getDaocl() {
		return daocl;
	}

	public void setDaocl(IClientDAO daocl) {
		this.daocl = daocl;
	}
	
	

	public void AjoutClientService(Client cl) {
		daocl.save(cl);
	}

	public void SupprimerClientService(Client cl) {
		daocl.delete(cl);
	}
	
	public void MAJClientService(Client cl) {
		daocl.saveAndFlush(cl);
	}
	
	public List<Client> GetAllClient() {
		return daocl.findAll();
	}

	public Client GetClientByIDService(long id) {
		return daocl.getOne(id);
	}
	
	public void SupClientByIDService(long id) {
		 daocl.deleteById(id);;
	}

}
