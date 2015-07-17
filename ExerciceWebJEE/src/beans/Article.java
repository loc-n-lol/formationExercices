package beans;

public class Article {

	private int id;
	private String libelle;
	private double prix;
	private double poids;
	
	
	
	
	public Article() {
		this(0, "", 0, 0);
	}

	public Article(int id, String libelle, double prix, double poids) {
		super();
		setId(id);
		setLibelle(libelle);
		setPrix(prix);
		setPoids(poids);
	}	
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", libelle=" + libelle + ", prix=" + prix
				+ ", poids=" + poids + "]";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	
}
