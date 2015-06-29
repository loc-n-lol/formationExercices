package echecs;

public class Fou extends Piece {

	public Fou(boolean couleur, int ligne, int colonne) {
		super(couleur, ligne, colonne);
	}

	@Override
	public String listeMouvements() {
		return listeMouvementsDiagonal(7);
	}

}
