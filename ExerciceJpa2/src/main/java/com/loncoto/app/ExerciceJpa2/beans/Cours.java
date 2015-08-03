package com.loncoto.app.ExerciceJpa2.beans;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cours {

	private int id;
	private Date datedebut, datefin;
	private String libelle;
	private Set<Etudiant> etudiants;
	private Matiere matiere;
	private Formateur formateur;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@ManyToMany
	@JoinTable(name="Participations", joinColumns={@JoinColumn(name="C_ID")}, inverseJoinColumns={@JoinColumn(name="E_ID")})
	public Set<Etudiant> getEtudiants() {
		if (etudiants == null)
			etudiants = new HashSet<Etudiant>();
		return etudiants;
	}
	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	public void addEtudiant(Etudiant e)
	{
		getEtudiants().add(e);
	}
	
	@ManyToOne
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	
	@ManyToOne
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Cours(Date datedebut, Date datefin, String libelle, Matiere matiere,
			Formateur formateur) {
		super();
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.libelle = libelle;
		this.matiere = matiere;
		this.formateur = formateur;
	}
	
	public Cours(){}
	@Override
	public String toString() {
		return "Cours [id=" + id + ", datedebut=" + datedebut + ", datefin="
				+ datefin + ", libelle=" + libelle + ", matiere=" + matiere.getDenomination()
				+ "]";
	}
	
	
}
