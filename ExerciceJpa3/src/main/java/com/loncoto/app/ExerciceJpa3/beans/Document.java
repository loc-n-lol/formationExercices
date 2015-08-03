package com.loncoto.app.ExerciceJpa3.beans;

import java.util.Date;
import javax.persistence.*;


@Entity
public class Document extends Content {

	private String titre, corps;
	
	public String getTitre() {return titre;}
	public void setTitre(String titre) {this.titre = titre;}
	
	@Column(columnDefinition="text")
	public String getCorps() {return corps;}
	public void setCorps(String corps) {this.corps = corps;}
	
	public Document() {
		super();
	}
	
	public Document(/*Date dateCreation, Date dateModification,*/ String nom,
			String titre, String corps) {
		super(/*dateCreation, dateModification,*/ nom);
		this.titre = titre;
		this.corps = corps;
	}
	
}
