package com.loncoto.app.ExerciceJpa3.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.loncoto.app.ExerciceJpa3.beans.*;

public class JpaTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testHibernate");
        Scanner input = new Scanner(System.in);

        input.nextLine();
        System.out.println("--------------------------------------");
		test1(emf);

        input.nextLine();
		System.out.println("--------------------------------------");
		test2(emf);

        input.nextLine();
		System.out.println("--------------------------------------");		

	    emf.close();
		System.out.println("done...");
	}




	public static void test1(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------

		Random rng = new Random();
		
		Gallerie g = new Gallerie(/*new Date(), new Date(),*/ "Gallerie");
		em.persist(g);
		
		for (int i = 1 ; i<=20; i++)
		{

			Content c;
			
			if (rng.nextBoolean())
			{
			Image img = new Image(/*new Date(), new Date(),*/ "Image"+i, "fichier_image"+i+".jpg", "JPEG");
			c = img;
			
			if (rng.nextBoolean())
				g.addImage(img);
			
			}
			else
			{
				c = new Document(/*new Date(), new Date(),*/ "Doc"+i, "Titre"+i, "Lorem Ipsum"+i);
			}
			
			em.persist(c);
			
			
		}
		
		for (int i = 1 ; i<=10; i++)
		{
			Tag t = new Tag("tag"+i);
			em.persist(t);
			t.addContent(em.find(Content.class, rng.nextInt(20)+1));
		}
		
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}


	public static void test2(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------

		Scanner input = new Scanner(System.in);
		
		System.out.println("id d'un document à modifier:");
		
		int id = Integer.parseInt(input.nextLine());
		
		Document d = em.find(Document.class, id);
		
		if (d != null)
		{
			System.out.println("nouveau titre ? :");
			
			d.setTitre(input.nextLine());
		}
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
