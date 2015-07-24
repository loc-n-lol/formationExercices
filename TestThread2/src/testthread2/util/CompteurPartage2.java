package testthread2.util;

import java.util.concurrent.atomic.AtomicInteger;

public class CompteurPartage2 {

	private AtomicInteger compteur;
	
	public CompteurPartage2() {
		this.compteur= new AtomicInteger(0);
	}
	
	public int augmentcompteur()
	{
		return this.compteur.incrementAndGet();
	}

	@Override
	public String toString() {
		return "CompteurPartage2 [compteur=" + compteur.get() + "]";
	}
	
}
