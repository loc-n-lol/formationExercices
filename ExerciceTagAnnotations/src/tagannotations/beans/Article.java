package tagannotations.beans;

import tagannotations.annotations.ChampFormulaire;

public class Article {
	private int id;
	

	@ChampFormulaire(label="nom article", name="nom")
	private String nom;

	@ChampFormulaire(label="prix article", name="prix")
	private double prix;

	@ChampFormulaire(label="poids article", name="poids")
	private double poids;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	public Article() { this (0, "", 0.0, 0.0); }
	public Article(int id, String libelle, double prix, double poids) {
		super();
		this.id = id;
		this.nom = libelle;
		this.prix = prix;
		this.poids = poids;
	}
	
	

}
