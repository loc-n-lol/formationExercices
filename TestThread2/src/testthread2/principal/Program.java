package testthread2.principal;

import testthread2.util.CompteurPartage;
import testthread2.util.CompteurPartage2;
import testthread2.util.Worker1;
import testthread2.util.Worker2;

public class Program {

	public static void main(String[] args) {

		CompteurPartage2 compteur = new CompteurPartage2();
		
		Thread t1 = new Thread(new Worker2("w1", compteur));
		Thread t2 = new Thread(new Worker2("w2", compteur));
		Thread t3 = new Thread(new Worker2("w3", compteur));
		
		System.out.println(compteur);
		System.out.println("démarrage");
		
		t1.start(); t2.start(); t3.start();
				
		try {
			t1.join(); t2.join(); t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(compteur);
	}

}
