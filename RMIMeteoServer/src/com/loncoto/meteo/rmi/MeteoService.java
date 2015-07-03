package com.loncoto.meteo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MeteoService extends Remote {

	public String getPrevision(String ville) throws RemoteException;
	
}
