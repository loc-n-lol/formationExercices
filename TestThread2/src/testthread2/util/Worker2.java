package testthread2.util;

public class Worker2 implements Runnable 
{

	private CompteurPartage2 compteur;
	private String nom;

	public Worker2(String nom, CompteurPartage2 compteur) 
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
