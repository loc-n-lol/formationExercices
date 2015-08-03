package com.loncoto.app.ExerciceJpa3.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Content {

	
	private int id;
	private Date dateCreation, dateModification;
	private String nom;
	
	private Set<Tag> tags;

	// appelé automatiquement avant tout insertion de cette entité
	@PrePersist
	public void createContent()
	{
		Date d = new Date();
		setDateCreation(d);
		setDateModification(d);
	}

	// appelé automatiquement avant toute mise à jour dans la base de cette entité
	@PreUpdate
	public void updateContent()
	{
		Date d = new Date();
		//setDateCreation(d);
		setDateModification(d);
	}
	
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public Date getDateCreation() {return dateCreation;}
	public void setDateCreation(Date dateCreation) {this.dateCreation = dateCreation;}
	public Date getDateModification() {return dateModification;}
	public void setDateModification(Date dateModification) {this.dateModification = dateModification;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	
	@ManyToMany(mappedBy="contents")
	public Set<Tag> getTags() 
	{
		if (tags == null)
			tags = new HashSet<Tag>();
		
		return tags;
	}
	public void setTags(Set<Tag> tags) {this.tags = tags;}
	
	public Content() {
		super();
	}
	
	public Content(/*Date dateCreation, Date dateModification,*/ String nom) {
		super();
		//this.dateCreation = dateCreation;
		//this.dateModification = dateModification;
		this.nom = nom;
	}
	
	
}
