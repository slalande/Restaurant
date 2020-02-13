package com.adaming.restaurant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Menu {
	
	@Id
	private long idMenu;
	@Column
	private String nomMenu;
	@Column
	private double prixMenu;
	@Column
	private boolean vegan;
	@OneToMany(mappedBy="menu", cascade=CascadeType.PERSIST)
	private List<Plat> lstplats;	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="lstmenus")
	private List<Reservation> lstres;
	public long getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(long idMenu) {
		this.idMenu = idMenu;
	}
	public String getNomMenu() {
		return nomMenu;
	}
	public void setNomMenu(String nomMenu) {
		this.nomMenu = nomMenu;
	}
	public double getPrixMenu() {
		return prixMenu;
	}
	public void setPrixMenu(double prixMenu) {
		this.prixMenu = prixMenu;
	}
	public boolean isVegan() {
		return vegan;
	}
	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}
	public List<Plat> getLstplats() {
		return lstplats;
	}
	public void setLstplats(List<Plat> lstplats) {
		this.lstplats = lstplats;
	}
	public List<Reservation> getLstres() {
		return lstres;
	}
	public void setLstres(List<Reservation> lstres) {
		this.lstres = lstres;
	}
	public Menu(long idMenu, String nomMenu, double prixMenu, boolean vegan) {
		super();
		this.idMenu = idMenu;
		this.nomMenu = nomMenu;
		this.prixMenu = prixMenu;
		this.vegan = vegan;
	}
	public Menu(long idMenu, String nomMenu, double prixMenu, boolean vegan, List<Plat> lstplats,
			List<Reservation> lstres) {
		super();
		this.idMenu = idMenu;
		this.nomMenu = nomMenu;
		this.prixMenu = prixMenu;
		this.vegan = vegan;
		this.lstplats = lstplats;
		this.lstres = lstres;
	}
	public Menu() {
		super();
	}
	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + ", nomMenu=" + nomMenu + ", prixMenu=" + prixMenu + ", vegan=" + vegan + "]";
	}


	

}
