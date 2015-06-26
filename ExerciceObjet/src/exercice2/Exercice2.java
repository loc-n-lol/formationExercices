package exercice2;

import produit.Produit;

public class Exercice2 {

	public static void main(String[] args) {
		Produit p1 = new Produit("dfgj", 20, Math.random()*10);
		Produit p2 = new Produit("fghfgh", 10, Math.random()*20);
		Produit p3 = new Produit("dfghdgh", 50, Math.random()*3);
		Produit p4 = new Produit("dfghd", 5, Math.random()*5);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		
		System.out.println(p2.getPrice(1));
		System.out.println(p2.getPrice(2));
		System.out.println(p2.getPrice(10));
		System.out.println(p2.getPrice(20));
	}

}
