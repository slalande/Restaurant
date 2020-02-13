package com.adaming.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.restaurant.dao.IMenuDAO;
import com.adaming.restaurant.entity.Menu;

@Service
public class MenuService {
	
	@Autowired
	private IMenuDAO daomenu;

	public IMenuDAO getDaomenu() {
		return daomenu;
	}

	public void setDaomenu(IMenuDAO daomenu) {
		this.daomenu = daomenu;
	}
	
	public void AjoutMenuService(Menu m) {
		daomenu.save(m);
	}
	
	public void SupprimerMenuService(Menu m) {
		daomenu.delete(m);
	}
	
	public void MAJMenuService(Menu m) {
		daomenu.saveAndFlush(m);
	}
	
	public List<Menu> GetAllMenuService() {
		return daomenu.findAll();
	}
	
	public Menu GetMenuByID(long id) {
		return daomenu.getOne(id);
	}
	
	public void SupMenuByID(long id) {
		daomenu.deleteById(id);
	}
	

}
