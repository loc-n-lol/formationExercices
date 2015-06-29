package main;

import echecs.*;

public class Main {

	public static void main(String[] args) {
		
		Piece p1 = new Pion (Piece.BLANC, 1, 2);
		Piece p2 = new Tour (Piece.BLANC, 0, 0);
		Piece p3 = new Fou (Piece.BLANC, 0, 2);
		Piece p4 = new Reine (Piece.BLANC, 0, 3);
		Piece p5 = new Roi (Piece.BLANC, 0, 4);
		
		System.out.println(p1.getClass().getName() + ":" + p1.posToString() + "->" + p1.listeMouvements());
		System.out.println(p2.getClass().getName() + ":" + p2.posToString() + "->" + p2.listeMouvements());
		System.out.println(p3.getClass().getName() + ":" + p3.posToString() + "->" + p3.listeMouvements());
		System.out.println(p4.getClass().getName() + ":" + p4.posToString() + "->" + p4.listeMouvements());
		System.out.println(p5.getClass().getName() + ":" + p5.posToString() + "->" + p5.listeMouvements());
	}

}
