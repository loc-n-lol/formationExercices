import java.util.Scanner;

import temperature.ConversionTemperature;
import temperature.TemperatureNegativeException;
import temperature.TemperatureUniteInvalideException;


public class Main {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int unit1, unit2; char u1car, u2car; double valRet = 0;
		System.out.println("unité d'entrée (K/C/F) :");
		
		while(true)
		{
			try {
				
				String u1 = reader.nextLine().toUpperCase();
				switch (u1car = u1.charAt(0))
				{
				case 'K':
					unit1=ConversionTemperature.uniteKelvin; break;
				case 'C':
					unit1=ConversionTemperature.uniteCelsius; break;
				case 'F':
					unit1=ConversionTemperature.uniteFahreneit; break;
				default:
					throw new TemperatureUniteInvalideException();	
				}
				break;
				
			} catch (TemperatureUniteInvalideException e) {
				System.out.println(e.getMessage());
				System.out.println("Essayez encore: ");
			}
		}
		
		System.out.println("unité en sortie (K/C/F) :");
		
		while(true)
		{
			try {
				
				String u2 = reader.nextLine().toUpperCase();
				switch (u2car = u2.charAt(0))
				{
				case 'K':
					unit2=ConversionTemperature.uniteKelvin; break;
				case 'C':
					unit2=ConversionTemperature.uniteCelsius; break;
				case 'F':
					unit2=ConversionTemperature.uniteFahreneit; break;
				default:
					throw new TemperatureUniteInvalideException();	
				}
				break;
				
			} catch (TemperatureUniteInvalideException e) {
				System.out.println(e.getMessage());
				System.out.println("Essayez encore: ");
			}
		}
		
		System.out.println("valeur d'entrée (" + u1car + ") :");
		
		while(true)
		{
			try {
				
				String u1 = reader.nextLine();
				double valeur = Double.parseDouble(u1);
				valRet = ConversionTemperature.conversionGenerale(valeur, unit1, unit2);
				break;		
			} 
				catch (TemperatureNegativeException e) {
				System.out.println(e.getMessage());
				System.out.println("Essayez encore: ");
			} 
				catch (NumberFormatException e) {
				System.out.println("Format de nombre invalide");
				System.out.println("Essayez encore: ");
			}
		}
		
		System.out.println("Résultat : " + valRet + "°" + u2car);
	
		reader.close();
			
	}

}
