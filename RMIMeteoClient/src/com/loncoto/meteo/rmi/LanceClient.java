package com.loncoto.meteo.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public class LanceClient {

	public static void main(String[] args)
	{
		System.out.println("Lancement client");
		
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new RMISecurityManager());
		}
		
		System.out.println("Quelle adresse ?");
		
		Scanner reader = new Scanner(System.in);
		
		String url = reader.nextLine();
		
		url = "rmi://" + url;
		
		try {
			//On récupère le service meteo distant
			Remote r = Naming.lookup(url);
			
			if (r instanceof MeteoService)
			{
				System.out.println("connected to MeteoService -> " + r);
				//Conversion vers le bon type de service
				MeteoService ms = (MeteoService)r;
				
				System.out.println("connecté!");
				
				//Boucle d'utilisation du service
				while (true)
				{
					System.out.println("Quelle ville (rien pour terminer)");
					String ville = reader.nextLine();
					
					if (ville.length() == 0)
						break;
								
					System.out.println(ms.getPrevision(ville));
				}
				
				System.out.println("Terminé, merci");
			}
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
