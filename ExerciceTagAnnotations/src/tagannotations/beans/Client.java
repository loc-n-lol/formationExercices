package tagannotations.beans;

import tagannotations.annotations.ChampFormulaire;

public class Client {
	private int id;
	
	@ChampFormulaire(label="nom client", name="nom")
	public String nom;
	
	@ChampFormulaire(label="e-mail", name="email")
	public String email;
	
	@ChampFormulaire(label="solde", name="solde")
	public double solde;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public Client() { this(0, "","", 0.0);}
	public Client(int id, String nom, String email, double solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.solde = solde;
	}
	
}
	
