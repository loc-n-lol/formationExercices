package com.loncoto.app.ExerciceJpa2.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Etudiant {

	private int id;
	private String nom, email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToMany(mappedBy="etudiants")
	public Set<Cours> getCours() {
		if (cours == null)
			cours = new HashSet<Cours>();
		return cours;
	}
	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}
	
	
	public Etudiant(String nom, String email) {
		super();
		this.nom = nom;
		this.email = email;
	}
	public Etudiant() {}
	
	
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", email=" + email + "]";
	}
}
