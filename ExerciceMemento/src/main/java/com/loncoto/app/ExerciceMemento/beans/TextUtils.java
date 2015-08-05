package com.loncoto.app.ExerciceMemento.beans;

public class TextUtils implements ITextUtils {

	@Override
	public String texteInverse(String chaine)
	{
		System.out.println("Appel de TextUtils.texteInverse("+chaine+")");
		
		StringBuilder sb = new StringBuilder();
		for (int i=chaine.length()-1 ; i >= 0 ; i--)
			sb.append(chaine.charAt(i));
		
		return sb.toString();
	}
	
	@Override
	public String texteMajuscule(String chaine)
	{
		System.out.println("Appel de TextUtils.texteMajuscule("+chaine+")");
		

		return chaine.toUpperCase();
	}	
	
	@Override
	public int texteLongueur(String chaine)
	{
		System.out.println("Appel de TextUtils.texteLongueur("+chaine+")");
		

		return chaine.length();
	}	
	
	@Override
	public String texte1337(String chaine)
	{
		System.out.println("Appel de TextUtils.texte1337("+chaine+")");
		
		StringBuilder sb = new StringBuilder();
		for (int i=0 ; i < chaine.length() ; i++)
		{
			char c = chaine.charAt(i);
			
			c=Character.toLowerCase(c);
			
			switch(c)
			{
			case 'e':
				c = '3'; break;
			case 'a':
				c = '4'; break;
			case 'i':
				c = '1'; break;
			case 'o':
				c = '0'; break;
			}
			
			if (i%2==0 && Character.isLetter(c))
				c=Character.toUpperCase(c);
			
			sb.append(c);
		}
		
		return sb.toString();
	}
	
}
