package echecs;

public class Roi extends Piece {

	public Roi(boolean couleur, int ligne, int colonne) {
		super(couleur, ligne, colonne);
	}

	@Override
	public String listeMouvements() {
		return listeMouvementsDiagonal(1) + listeMouvementsVertical(1) + listeMouvementsHorizontal(1);
	}

}
