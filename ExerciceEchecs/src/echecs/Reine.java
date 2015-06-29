package echecs;

public class Reine extends Piece {

	public Reine(boolean couleur, int ligne, int colonne) {
		super(couleur, ligne, colonne);
	}

	@Override
	public String listeMouvements() {
		return listeMouvementsDiagonal(7) + listeMouvementsVertical(7) + listeMouvementsHorizontal(7);
	}

}
