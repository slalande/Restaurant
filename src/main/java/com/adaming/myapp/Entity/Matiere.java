package com.adaming.myapp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Matiere {
	
	@Id
	private long idMatiere;
	@Column
	private String nomMatiere;
	
	
	public long getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(long idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getNomMatiere() {
		return nomMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	public Matiere(long idMatiere, String nomMatiere) {
		super();
		this.idMatiere = idMatiere;
		this.nomMatiere = nomMatiere;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Matiere [idMatiere=" + idMatiere + ", nomMatiere=" + nomMatiere + "]";
	}
	
	

}
