import java.util.Scanner;


public class ExerciceTableaux {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);

		System.out.println("Nombre de notes ?");
		
		int nbNotes = Integer.parseInt(reader.nextLine());
		
		double[] notes = new double[nbNotes];
		
		System.out.println("Entrer Notes:");
		
		double somme = 0.0, moyenne, min = Double.MAX_VALUE, max = -Double.MAX_VALUE;
		
		for (int i = 0; i < nbNotes; i++)
		{
			notes[i] = Double.parseDouble(reader.nextLine());
			
			somme += notes[i];
			
			if (notes[i] < min)
				min = notes[i];
			
			if (notes[i] > max)
				max = notes[i];
		}
		
		reader.close();

		
		//MOYENNE
		moyenne = somme / nbNotes;	
		System.out.println("Moyenne: "+moyenne);
			
		//MIN
		System.out.println("Min: "+min);
		
		//MAX
		System.out.println("Max: "+max);
		
		//NB DE NOTES AU-DESSUS DE LA MOYENNE
		double nbAuDessusMoy = 0;
		
		for (double note : notes)
		{
			if (note > moyenne)
				nbAuDessusMoy++;
		}
		System.out.println("Notes au dessus de la moyenne: "+nbAuDessusMoy);
	}
}
