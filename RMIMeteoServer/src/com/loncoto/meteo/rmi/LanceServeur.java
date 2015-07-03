package com.loncoto.meteo.rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class LanceServeur {

	public static void main(String[] args) {

		try {
			
			//Creation d'un "annuaire" des services
			//remote qu'on va fournir
			LocateRegistry.createRegistry(1099);
			
			if (System.getSecurityManager() == null)
			{				
				System.setSecurityManager(new RMISecurityManager());							
			}
			
			//J'instancie mon fournisseur de service meteo
			MeteoServiceImpl meteoserv = new MeteoServiceImpl();
			
			//Je construis l'url de mon service
			String adresse = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/meteoRMI";
			
			System.out.println("url = " + adresse);
			
			Naming.bind(adresse, meteoserv);
			
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
