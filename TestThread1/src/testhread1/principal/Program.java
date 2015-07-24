package testhread1.principal;

import java.util.Scanner;

import testhread1.util.Worker1;
import testhread1.util.Worker2;

public class Program {

	public static void main(String[] args)
	{
		Worker1 w1 = new Worker1("w1");
		Worker1 w2 = new Worker1("w2");
		Worker1 w3 = new Worker1("w3");
		
		// le thread est créé, mais non démarré
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w2);
		Thread t3 = new Thread(w3);
		Worker2 t4 = new Worker2("w4");
		
		System.out.println("démarrage thread 1");
		t1.start();
		System.out.println("démarrage thread 2");
		t2.start();
		System.out.println("démarrage thread 3");
		t3.start();
		System.out.println("démarrage thread 4");
		t4.start();
		
		Scanner reader = new Scanner(System.in);
		
		try {
			
			while (true) {
				System.out.println("Attente de thread 1, forcer arret ?");
				if (reader.hasNext())
				{
					w1.setMustStop(true);
					w2.setMustStop(true);
					w3.setMustStop(true);
					t4.setMustStop(true);
				}
				
				
				t1.join(1000);
				if (!t1.isAlive())
					break;
			}
			System.out.println("Attente de thread 2");
			t2.join();
			System.out.println("Attente de thread 3");
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("---------fini");
	}
	
}
