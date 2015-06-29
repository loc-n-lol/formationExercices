package echecs;

public abstract class Piece {

	public static final boolean BLANC = true;
	public static final boolean NOIR = false;
	
	private boolean couleur;
	private int ligne, colonne;
	
	public Piece(boolean couleur, int ligne, int colonne)
	{
		this.couleur = couleur;
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public abstract String listeMouvements();
	
	public String listeMouvementsVertical(int distanceMax)
	{
		String ret = "";
		
		for (int i=0; i<8; i++)
		{
			if (i!=getColonne() && (Math.abs(i - getLigne()) <= distanceMax))
				ret += posToString(getLigne(), i) + " ";
		}
		
		return ret;
	}
	
	public String listeMouvementsHorizontal(int distanceMax)
	{
		String ret = "";
		
		for (int i=0; i<8; i++)
		{
			if (i!=getLigne() && (Math.abs(i - getLigne()) <= distanceMax))
				ret += posToString(i, getColonne())+ " " ;
		}
		
		return ret;
	}
	
	public String listeMouvementsDiagonal(int distanceMax)
	{
		String ret = "";
		
		for (int i=1; i<=distanceMax; i++)
		{
			if (getLigne() - i >= 0 && getColonne() - i >= 0)
				ret += posToString(getLigne() - i, getColonne() - i)+ " ";
			
			if (getLigne() + i <= 7 && getColonne() - i >= 0)
				ret += posToString(getLigne() + i, getColonne() - i)+ " ";
			
			if (getLigne() - i >= 0 && getColonne() + i <= 7)
				ret += posToString(getLigne() - i, getColonne() + i)+ " ";
			
			if (getLigne() + i <= 7 && getColonne() + i <= 7)
				ret += posToString(getLigne() + i, getColonne() + i)+ " ";
		}
		
		return ret;
	}
	
	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public boolean getCouleur() {
		return couleur;
	}
	
	public String posToString(int ligne, int colonne)
	{
		return Character.toString((char)('A'+colonne))  + Integer.toString(ligne+1) ;
	}
	
	public String posToString()
	{
		return posToString(ligne, colonne);
	}
	


}
