package com.loncoto.app.ExerciceJpa3.beans;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag {

	
	private int id;
	private String libelle;
	
	private Set<Content> contents;

	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	
	@ManyToMany
	public Set<Content> getContents() 
	{
		if (contents == null)
			contents = new HashSet<Content>();
		
		return contents;
	}
	public void setContents(Set<Content> contents) {this.contents = contents;}
	
	public void addContent(Content c)
	{
		getContents().add(c);
		c.getTags().add(this);
	}
	
	
	public Tag() {
		super();
	}
	
	public Tag(String libelle) {
		super();
		this.libelle = libelle;
	}
	

	
}
