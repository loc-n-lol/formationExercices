package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import util.Worker1;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("debut...");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("démarrage...");
		
		ExecutorService srv = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		srv.execute(new Worker1("w1"));
		srv.execute(new Worker1("w2"));
		srv.execute(new Worker1("w3"));
		srv.execute(new Worker1("w4"));
		srv.execute(new Worker1("w5"));
		srv.execute(new Worker1("w6"));
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//termine toutes les tachesplanifiées mais n'accepte pas de nouvelle tache
		System.out.println("attempting shutdown");
		srv.shutdown();
		
		try {
			while (true) {
				//j'attend au maximum 20 seconds que le thread pool se termine
				System.out.println("waiting for shutdown");
				srv.awaitTermination(1, TimeUnit.SECONDS);
				
				if (srv.isTerminated())
					break;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("terminé");

	}

}
