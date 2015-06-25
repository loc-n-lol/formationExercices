
public class ExerciceFonctionCalendrier {

	public static void main(String[] args) {

		int mois = 4, annee = 1986;
		//for (int annee = 1984; annee <= 2015; annee++)
		//	for (int mois = 1; mois <= 12; mois ++)	
				System.out.println(calendrier(mois, annee));

	}

	public static String calendrier(int mois, int annee) {
		return header(mois, annee) + body(mois, annee);
	}

	public static String body(int mois, int annee) {
		
		StringBuilder sb= new StringBuilder();
		
		int jour = premierJourDuMois(mois, annee);
		
		jour = (jour < 0) ? (jour + 7) : jour; 
		
		for (int i=0; i<jour ; i++)
		{
			sb.append("    ");
		}
		
		for (int i=1; i<=joursDansLeMois(mois, annee); i++)
		{
			sb.append(" "+(i < 10 ? " " : "")+i+" ");
			
			if ((jour + i) % 7 == 0)
				sb.append("\n");
		}
		
		return sb.toString(); 
	}

	public static String header(int mois, int annee)
	{
		StringBuilder sb= new StringBuilder();
		
		String sMois = mois(mois);
		
		sb.append("---------------------------\n");
		for (int i=0; i< (29-5-sMois.length())/2; i++)
			sb.append(' ');
		sb.append(sMois);
		sb.append(" ");
		sb.append(annee);
		sb.append("\n");
		sb.append("---------------------------\n");
		sb.append("LUN MAR MER JEU VEN SAM DIM\n");
		
		return sb.toString();
	}

	public static String mois(int mois) {
		switch (mois)
		{
			default:
				return "";
			case 1:
				return "JANVIER";
			case 2:
				return "FEVRIER";
			case 3:
				return "MARS";
			case 4:
				return "AVRIL";
			case 5:
				return "MAI";
			case 6:
				return "JUIN";
			case 7:
				return "JUILLET";
			case 8:
				return "AOUT";
			case 9:
				return "SEPTEMBRE";
			case 10:
				return "OCTOBRE";
			case 11:
				return "NOVEMBRE";
			case 12:
				return "DECEMBRE";
		}
	}
	
	public static int joursDansLeMois(int mois, int annee)
	{
		switch (mois)
		{
			default:
				return -1;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				return (estBissextile(annee) ? 29 : 28);
		}
	}
	
	public static boolean estBissextile(int annee)
	{
		return (annee%4 == 0 && (annee%100 != 0 || annee%400 == 0));
	}
	
	public static int joursDansLAnnee(int annee)
	{
		return estBissextile(annee) ? 366 : 365;
	}
	
	public static int premierJourDuMois(int mois, int annee)
	{

		int jour = 3; //jeudi 1er Janvier 2015
		
		for (int an=2015; an<annee; an++)
		{			
			jour += joursDansLAnnee(an);
		}
		
		for (int an=2015; an>annee; an--)
		{			
			jour -= joursDansLAnnee(an-1);
		}
		
		for (int m=1; m < mois; m++)
		{
			jour+=joursDansLeMois(m, annee);
		}

		return (jour%7);

	}
	
	
}
