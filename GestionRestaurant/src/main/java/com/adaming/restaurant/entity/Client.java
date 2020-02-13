package com.adaming.restaurant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
 @Table
public class Client {
	
	@Id
	private long idClient;
	@Column 
	private String nom;
	@Column
	private double tel;
	@OneToMany(mappedBy="client", cascade=CascadeType.PERSIST)
	private List<Reservation> lstres;
	
	
	
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getTel() {
		return tel;
	}
	public void setTel(double tel) {
		this.tel = tel;
	}
	public Client(long idClient, String nom, double tel) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.tel = tel;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", tel=" + tel + "]";
	}
	
	
	

}
