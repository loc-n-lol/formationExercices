package com.loncoto.app.ExerciceJpa3.beans;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Image extends Content {

	private String fileName, contentType;
	
	
	public String getFileName() {return fileName;}
	public void setFileName(String fileName) {this.fileName = fileName;}
	public String getContentType() {return contentType;}
	public void setContentType(String contentType) {this.contentType = contentType;}
	
	public Image() {
		super();
	}
	
	public Image(/*Date dateCreation, Date dateModification,*/ String nom,
			String fileName, String contentType) {
		super(/*dateCreation, dateModification,*/ nom);
		this.fileName = fileName;
		this.contentType = contentType;
	}
	
	
}
