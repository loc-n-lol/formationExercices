package com.loncoto.webapps.ExerciceSpringPlusPlus.metier;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Intervenant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private String email;
	
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	@Override
	public String toString() {
		return nom + "<" + email + ">";
	}
}
