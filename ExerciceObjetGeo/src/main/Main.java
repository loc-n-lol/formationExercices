package main;

import geometrie.*;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {

		Vector<Figure> vec = new Vector<Figure>();
		
		for (int i = 0; i< 10; i++)
			if (Math.random() < 0.5)
				vec.add(new Triangle());
			else
				vec.add(new Rectangle());
		
		for (Figure f : vec)
			f.afficher();
	}

}
