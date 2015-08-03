package com.loncoto.app.ExerciceJpa2.beans;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Formateur {

	private int id;
	private String nom, prenom;
	private Set<Cours> cours;
	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@OneToMany(mappedBy="formateur")
	public Set<Cours> getCours() {
		return cours;
	}
	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}
	
	public Formateur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Formateur() {}
	
	
	@Override
	public String toString() {
		return "Formateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ "]";
	}
	
	
	
	
}
