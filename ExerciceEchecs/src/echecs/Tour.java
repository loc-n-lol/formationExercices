package echecs;

public class Tour extends Piece {

	public Tour(boolean couleur, int ligne, int colonne) {
		super(couleur, ligne, colonne);
	}

	@Override
	public String listeMouvements() {
		
		return listeMouvementsHorizontal(7)+listeMouvementsVertical(7);
	}

}
