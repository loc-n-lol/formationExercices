package main;

import java.util.ArrayList;
import java.util.Random;

import banque.*;

public class Main {

	public static void main(String[] args) {
		ICompteBancaire c1 = new CompteBanque1();
		ICompteBancaire c2 = new CompteBanque2();

		c1.depot(5000);
		c2.depot(3000);
		
		System.out.println(c1);
		System.out.println(c2);

		System.out.println("-----------------------------------");
		
		transfert(2500, c1, c2);
		
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println("-----------------------------------");
		
		transfert(6000, c2, c1);
		
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println("-----------------------------------");
		
		ArrayList<ICompteBancaire> list = new ArrayList<ICompteBancaire>();
		
		list.add(c1);
		list.add(c2);
		
		Random rng = new Random();
		
		for (int i=3; i < 10; i++)
		{
			if (rng.nextBoolean())
				list.add(new CompteBanque1((double)rng.nextInt(10000)));
			else
				list.add(new CompteBanque2((double)rng.nextInt(10000)));
		}
		
		list.add(new CompteBanque2(1234.65));
		list.add(new CompteBanque1(1234.56));
		
		list.sort(null);
		
		for (ICompteBancaire c : list)
		{
			System.out.println(c);
		}
	}
	
	public static boolean transfert(double valeur, ICompteBancaire compte1, ICompteBancaire compte2) {
		if (compte1.retrait(valeur))
		{
			compte2.depot(valeur);
			return true;
		}
		
		return false;
		
	}

}
