package com.loncoto.app.ExerciceJPA.beans;

import javax.persistence.*;

@Entity
public class Employe {

	private int id;
	private String nom, email;
	private int salaire;
	private Service service;
	

	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	
	@ManyToOne
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	public Employe() { this("", "", 0, null); }
	
	public Employe(String nom, String email, int salaire,
			Service service) {
		super();
		this.nom = nom;
		this.email = email;
		this.salaire = salaire;
		this.service = service;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", email=" + email
				+ ", salaire=" + salaire + ", service=" + service.getDenomination() + "]";
	}
	
	
	
}
