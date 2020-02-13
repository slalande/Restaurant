package com.adaming.restaurant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Plat {
	
	@Id
	private long idPlat;
	@Column
	private String nomPlat;
	@Column
	private double prix;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="menu")
	private Menu menu;
	
	
	public long getIdPlat() {
		return idPlat;
	}
	public void setIdPlat(long idPlat) {
		this.idPlat = idPlat;
	}
	public String getNomPlat() {
		return nomPlat;
	}
	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Plat(long idPlat, String nomPlat, double prix, Menu menu) {
		super();
		this.idPlat = idPlat;
		this.nomPlat = nomPlat;
		this.prix = prix;
		this.menu = menu;
	}
	public Plat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Plat [idPlat=" + idPlat + ", nomPlat=" + nomPlat + ", prix=" + prix + ", menu=" + menu + "]";
	}
	
	

	
	

}
