package com.adaming.restaurant.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Reservation {
	
	@Id
	private long idReservation;
	@Column
	private int nbPersonnes;
	@Column
	private Date date;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="client")
	private Client client;
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="affectation", joinColumns=@JoinColumn(name="lstres"), inverseJoinColumns=@JoinColumn(name="lstmenus"))
	private List<Menu> lstmenus;
	public long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}
	public int getNbPersonnes() {
		return nbPersonnes;
	}
	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Menu> getLstmenus() {
		return lstmenus;
	}
	public void setLstmenus(List<Menu> lstmenus) {
		this.lstmenus = lstmenus;
	}
	public Reservation(long idReservation, int nbPersonnes, Date date, Client client, List<Menu> lstmenus) {
		super();
		this.idReservation = idReservation;
		this.nbPersonnes = nbPersonnes;
		this.date = date;
		this.client = client;
		this.lstmenus = lstmenus;
	}
	public Reservation(long idReservation, int nbPersonnes, Date date, Client client) {
		super();
		this.idReservation = idReservation;
		this.nbPersonnes = nbPersonnes;
		this.date = date;
		this.client = client;
	}
	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", nbPersonnes=" + nbPersonnes + ", date=" + date
				+ ", client=" + client + ", lstmenus=" + lstmenus + "]";
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
