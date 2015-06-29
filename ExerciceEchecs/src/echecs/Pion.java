package echecs;

public class Pion extends Piece {

	private boolean a_bouge;
	
	public Pion(boolean couleur, int ligne, int colonne) {
		super(couleur, ligne, colonne);
		a_bouge = false;
	}

	@Override
	public String listeMouvements() {
		String ret ="";
		
		if (getCouleur() == Piece.NOIR) //noir
		{
			ret = ret + posToString(getLigne()-1, getColonne());
		}
		else //blanc
		{
			ret = ret + posToString(getLigne()+1, getColonne());
		}
		
		return ret;
	}

}
