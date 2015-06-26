package produit;

public class Produit {

	private static int dernier_id = 0;
	private int id;
	private String nom;
	private double poids, prix;
	
	public Produit(String nom, double prix, double poids)
	{
		id = ++dernier_id;
		setNom(nom);
		setPrix(prix);
		setPoids(poids);
	}
	
	public String toString()
	{
		return "Produit "+nom+" ("+id+") prix: "+prix+" poids: "+poids;
	}
	
	public double getPrice(int qte)
	{
		return (qte >= 10 ? 0.95 : 1.0) * qte * prix;
		
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return id;
	}	
	
}
