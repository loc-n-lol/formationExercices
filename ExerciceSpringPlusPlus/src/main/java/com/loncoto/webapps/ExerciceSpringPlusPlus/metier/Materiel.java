package com.loncoto.webapps.ExerciceSpringPlusPlus.metier;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Materiel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String noSerie;
	private String nom;
	
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNoSerie() {return noSerie;}
	public void setNoSerie(String noSerie) {this.noSerie = noSerie;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	
	@Override
	public String toString() {
		return nom + "[" + noSerie + "]";
	}
	
	
}
