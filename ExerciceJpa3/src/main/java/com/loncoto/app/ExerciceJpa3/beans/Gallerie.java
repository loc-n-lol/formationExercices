package com.loncoto.app.ExerciceJpa3.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Gallerie extends Content {

	public Set<Image> images;

	@OneToMany
	public Set<Image> getImages() {
		if (images == null)
			images = new HashSet<Image>();
		return images;
	}

	public void setImages(Set<Image> images) {this.images = images;}
	public void addImage(Image i)
	{
		getImages().add(i);
	}

	public Gallerie() {
		super();
	}

	public Gallerie(/*Date dateCreation, Date dateModification,*/ String nom) {
		super(/*dateCreation, dateModification,*/ nom);
	}
	
}
