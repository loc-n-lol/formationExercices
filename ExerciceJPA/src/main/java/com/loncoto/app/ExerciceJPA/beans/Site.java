package com.loncoto.app.ExerciceJPA.beans;

import javax.persistence.*;

@Entity
public class Site {

	private int id;
	private String nom, adresse;
	
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	public Site() {
		this("", "");
	}
	public Site(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Site [id=" + id + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
}
