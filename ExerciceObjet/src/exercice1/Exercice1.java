package exercice1;

import geometrie.Rectangle;

public class Exercice1 {

	public static void main (String args[])
	{
		Rectangle r1 = new Rectangle(2, 3, 10, 5);
		
		System.out.println(r1);
		System.out.println(r1.getAire());
		
		Rectangle r2 = new Rectangle(r1);
		
		r2.deplacer(10, 5);
		
		System.out.println(r2);
		System.out.println(Rectangle.collision(r1, r2));
		
	}
}
