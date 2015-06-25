import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;


public class ExerciceFonctions {

	public static void main(String[] args) throws IOException
	{
		System.out.println("Exercice 1");
		
		int[] tab;
		tab = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(tab)+" -> "+nbImpairesDsTableau(tab));
		tab = new int[]{1, 3, 5};
		System.out.println(Arrays.toString(tab)+" -> "+nbImpairesDsTableau(tab));
		tab = new int[]{2, 8, 10, 14};
		System.out.println(Arrays.toString(tab)+" -> "+nbImpairesDsTableau(tab));
		
		System.out.println("--------------------------------------------");
		System.out.println("Exercice 2");
		
		String s;
		s = "radar";
		System.out.println(s+" : "+estPalindrome(s));
		s = "serres";
		System.out.println(s+" : "+estPalindrome(s));
		s = "toto";
		System.out.println(s+" : "+estPalindrome(s));
		
		System.out.println("--------------------------------------------");
		System.out.println("Exercice 3");
		
		double somme1, somme2, taux;
		somme1= 1000; somme2 = 1100; taux=0.01;
		System.out.println("Init:"+somme1+ " Final:"+somme2+" Taux:"+taux+" Annees:"+interets(somme1, taux, somme2));
		somme1= 1000; somme2 = 2000; taux=0.05;
		System.out.println("Init:"+somme1+ " Final:"+somme2+" Taux:"+taux+" Annees:"+interets(somme1, taux, somme2));
		somme1= 1000; somme2 = 1010; taux=0.01;
		System.out.println("Init:"+somme1+ " Final:"+somme2+" Taux:"+taux+" Annees:"+interets(somme1, taux, somme2));
		
		System.out.println("--------------------------------------------");
		System.out.println("Exercice 4");
		
		int n;
		n=1968;
		System.out.print("Nombre: "+n+" en romain :"); nbRomain(n); System.out.println();
		n=2015;
		System.out.print("Nombre: "+n+" en romain :"); nbRomain(n); System.out.println();
		n=999;
		System.out.print("Nombre: "+n+" en romain :"); nbRomain(n); System.out.println();
		
		System.out.println("--------------------------------------------");
		System.out.println("Exercice 5");
		
		File f = new File("exerciceFonctions5.txt");
		if (!f.exists())
		{
			f.createNewFile();
		}
		
		rapport(f);
		
	}
	
	

	public static int nbImpairesDsTableau(int[] tab)
	{
		int ret = 0;
		
		for (int i : tab)
			if (i % 2 == 1)
				ret++;
		
		return ret;
	}
	
	public static boolean estPalindrome(String s)
	{
		for (int i=0; i<s.length()/2; i++)
		{
			if (s.charAt(i) != s.charAt(s.length() -1 -i))
				return false;
		}
		
		return true;
	}
	
	public static int interets(double sommeInitiale, double taux, double sommeFinale)
	{
		int ret = 0;
		double somme = sommeInitiale;
		while (somme < sommeFinale)
		{
			somme *= (1+taux);
			ret++;
		}
		
		return ret;
	}
	
	public static void nbRomain(int n)
	{
		if (n >= 1000)
		{
			System.out.print('M');
			nbRomain(n-1000);
		}
		else if (n >= 900)
		{
			System.out.print("CM");
			nbRomain(n-900);
		}
		else if (n >= 500)
		{
			System.out.print('D');
			nbRomain(n-500);
		}
		else if (n >= 400)
		{
			System.out.print("CD");
			nbRomain(n-400);
		}
		else if (n >= 100)
		{
			System.out.print('C');
			nbRomain(n-100);
		}
		else if (n >= 90)
		{
			System.out.print("XC");
			nbRomain(n-90);
		}
		else if (n >= 50)
		{
			System.out.print('L');
			nbRomain(n-50);
		}
		else if (n >= 40)
		{
			System.out.print("XL");
			nbRomain(n-40);
		}
		else if (n>= 10)
		{
			System.out.print('X');
			nbRomain(n-10);
		}
		else if (n>= 9)
		{
			System.out.print("IX");
			nbRomain(n-10);
		}
		else if (n>= 5)
		{
			System.out.print('V');
			nbRomain(n-5);
		}
		else if (n>= 4)
		{
			System.out.print("IV");
			nbRomain(n-4);
		}
		else if (n>= 1)
		{
			System.out.print('I');
			nbRomain(n-1);
		}
		
	}
	
	public static void rapport(File f) throws IOException {
		File rapport = new File(f.getName()+".rapport.txt");
		
		rapport.createNewFile();
	
		Scanner reader = new Scanner(f);
		PrintWriter writer = new PrintWriter(rapport);
		
		int nbLettres = 0;
		int nbChars = 0;
		
		final int voyelleA = 0;
		final int voyelleE = 1;
		final int voyelleI = 2;
		final int voyelleO = 3;
		final int voyelleU = 4;
		final int voyelleY = 5;
		final int nbVoyelles = 6;
		
		final char[] voyelle = new char[]{ 'a', 'e', 'i', 'o', 'u', 'y' };
		
		int totalVoyelle[] = new int[nbVoyelles];
		double freqVoyelle[] = new double[nbVoyelles];
		
		int nbMots = 0;
		
		boolean estUnMot= false;
		
		
		while (reader.hasNext())
		{
			String line = reader.nextLine();

			for (int i=0; i< line.length(); i++)
			{
				char c = line.charAt(i);
				nbChars++;
				
				//espace
				if (Character.isSpaceChar(c) && estUnMot )
				{
					nbMots++;
					estUnMot = false;
				}
				
				//lettre
				if (Character.isLetter(c))
				{
					nbLettres++;
					estUnMot = true;
					
					switch(c)
					{
						case 'a':
							totalVoyelle[voyelleA]++; break;
						case 'e':
							totalVoyelle[voyelleE]++; break;
						case 'i':
							totalVoyelle[voyelleI]++; break;
						case 'o':
							totalVoyelle[voyelleO]++; break;
						case 'u':
							totalVoyelle[voyelleU]++; break;
						case 'y':
							totalVoyelle[voyelleY]++; break;
					}
				}
			}
			
			//Mot en fin de ligne
			if (estUnMot)
			{
				nbMots++;
				estUnMot = false;
			}
			
		}
		
		int totalVoyelles = 0;
		
		for (int v : totalVoyelle)
		{
			totalVoyelles += v;
		}
		
		for (int v=0; v<nbVoyelles; v++)
		{
			freqVoyelle[v]= (double)totalVoyelle[v] / (double)totalVoyelles;
		}
		
		writer.println("rapport sur le fichier "+f.getName());
		writer.println("-----------------------------------------------------------");
		writer.println("nombre de caractères: "+nbChars);
		writer.println("nombre de lettres: "+nbLettres);
		writer.println("nombre de mots: "+nbMots);
		writer.println("fréquence des voyelles: ");
		for (int v=0; v<nbVoyelles; v++)
			writer.println(""+voyelle[v]+": "+totalVoyelle[v]+"/"+totalVoyelles+" = "+freqVoyelle[v]);
		writer.println("longueur moyenne des mots: "+((double)nbLettres/(double)nbMots));
		
		writer.close();
	}
	
}
