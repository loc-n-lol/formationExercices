package com.loncoto.iteratorproject.principal;

import java.util.Iterator;

import com.loncoto.iteratorproject.reseau.IPInterval;

public class IPIntervalIterator implements Iterator<Integer[]> {

	//Interval que je vais parcourir
	private IPInterval interval;
	private int[] current;
	
	public IPIntervalIterator(IPInterval interval)
	{
		this.interval = interval;
		current = interval.getIpStart();
	}
	
	@Override
	public boolean hasNext() {
		return interval.isInInterval(current[0], current[1], current[2], current[3]);
		
	}

	@Override
	public Integer[] next() {
		//je récupère l'adresse ip sous forme d'un nombre
		long cur = ((long)current[0] << 24) + (current[1] << 16) + (current[2] << 8) + current[3];
		
		//j'incrémente le nombre
		cur++;
		
		//Je sauvegarde l'ip courante pour la renvoyer
		Integer[] curip = { current [0], current[1], current[2], current[3] };
		
		//Je réécrit l'ip incrémentée ) partir du chiffre incrémenté
		current[0] = (int) ((cur >> 24) & 255);
		current[1] = (int) ((cur >> 16) & 255);
		current[2] = (int) ((cur >> 8) & 255);
		current[3] = (int) ((cur) & 255);
		
		return curip;
	}

}
