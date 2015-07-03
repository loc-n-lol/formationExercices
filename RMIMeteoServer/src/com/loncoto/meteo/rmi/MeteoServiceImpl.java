package com.loncoto.meteo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class MeteoServiceImpl extends UnicastRemoteObject implements MeteoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5203586966885707365L;

	private Random rd;
	private String[] prevision = {"soleil", "neige", "pluie", "brume", "tempête de glace", "ouragan"};
	
	public MeteoServiceImpl() throws RemoteException {
		super();
		rd = new Random();
	}

	@Override
	public String getPrevision(String ville) throws RemoteException {
		
		System.out.println("Appel de meteo pour "+ville);
		
		StringBuilder sb = new StringBuilder("prevision pour "+ville);
		sb.append(": temps " + prevision[rd.nextInt(prevision.length)]);
		sb.append(", temperature = " + (rd.nextDouble() * 70.0 - 20.0) );
		
		return sb.toString();
	}

}
