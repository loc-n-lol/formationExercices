package testthread2.util;

public class Worker1 implements Runnable 
{

	private CompteurPartage compteur;
	private String nom;

	public Worker1(String nom, CompteurPartage compteur) 
	{
		super();
		this.nom = nom;
		this.compteur = compteur;
	}

	@Override
	public void run() 
	{

		for (int i = 0; i < 100000000; i++) 
		{
			compteur.augmentcompteur();

			if (i % 10000000 == 0)
				System.out.println(nom + " i = " + i);
		}

	}

}
