package com.loncoto.app.ExerciceMemento.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.loncoto.app.ExerciceMemento.beans.ITextUtils;


public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
        System.out.println("--------------------------------------");
        

        ITextUtils itu = ctx.getBean("tu", ITextUtils.class);
        
        System.out.println(itu.texteInverse("Test Spring"));
        System.out.println(itu.texteInverse("Test Spring"));
        System.out.println(itu.texteInverse("Test Spring2"));
        System.out.println(itu.texteInverse("Test Spring"));
        System.out.println(itu.texteInverse("Test Spring2"));
        
        System.out.println(itu.texteMajuscule("Test Spring"));
        System.out.println(itu.texteMajuscule("Test Spring"));
        System.out.println(itu.texteMajuscule("Test Spring2"));
        System.out.println(itu.texteMajuscule("Test Spring"));
        System.out.println(itu.texteMajuscule("Test Spring2"));      
        
        System.out.println(itu.texteLongueur("Test Spring"));
        System.out.println(itu.texteLongueur("Test Spring"));
        System.out.println(itu.texteLongueur("Test Spring2"));
        System.out.println(itu.texteLongueur("Test Spring"));
        System.out.println(itu.texteLongueur("Test Spring2"));
        
        System.out.println(itu.texte1337("Test Spring"));
        System.out.println(itu.texte1337("Test Spring"));
        System.out.println(itu.texte1337("Test Spring2"));
        System.out.println(itu.texte1337("Test Spring"));
        System.out.println(itu.texte1337("Test Spring2"));        
        
        
        input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
