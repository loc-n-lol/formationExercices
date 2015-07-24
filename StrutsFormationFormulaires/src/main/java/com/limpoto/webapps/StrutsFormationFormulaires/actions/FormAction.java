package com.limpoto.webapps.StrutsFormationFormulaires.actions;

import java.util.ArrayList;
import java.util.List;

import com.limpoto.webapps.StrutsFormationFormulaires.beans.Article;
import com.opensymphony.xwork2.ActionSupport;

public class FormAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String libelle;
	private double prix;
	private double poids;
	
	private int articleID;
	
	private List<Article> articles;


	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public List<Article> getArticles() {
		return articles;
	}
	
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	public double getPrix() {return prix;}
	public void setPrix(double prix) {this.prix = prix;}
	public double getPoids() {return poids;}
	public void setPoids(double poids) {this.poids = poids;}

	public String index() 
	{
		return SUCCESS;
	}

	public String enregistrer()
	{
		System.out.println("Reçu un article de libellé "+getLibelle()+" prix="+getPrix()+" poids="+getPoids());
		return SUCCESS;
	}
	
	public String liste()
	{
		articles = new ArrayList<Article>();
		
		articles.add(new Article(1, "table tek noire", 55.5, 2.5));
		articles.add(new Article(2, "table tek bleue", 45.5, 3.5));
		articles.add(new Article(3, "table tek rouge", 25.5, 4.5));
		
		articleID = 2;
		
		return SUCCESS;
	}
	
}
