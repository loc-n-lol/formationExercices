package com.loncoto.app.ExerciceJpa2.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Matiere {

	private int id;
	private String denomination;
	private Set<Cours> cours;
	
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	@OneToMany(mappedBy="matiere")
	public Set<Cours> getCours() {
		if (cours == null)
			cours = new HashSet<Cours>();
		return cours;
	}
	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}
	
	public Matiere(String denomination) {
		super();
		this.denomination = denomination;
	}
	
	public Matiere() {}
	
	
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", denomination=" + denomination + "]";
	}
	
	
}
