package com.loncoto.app.ExerciceJpa2.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.loncoto.app.ExerciceJpa2.beans.Cours;
import com.loncoto.app.ExerciceJpa2.beans.Etudiant;
import com.loncoto.app.ExerciceJpa2.beans.Formateur;
import com.loncoto.app.ExerciceJpa2.beans.Matiere;

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
		test3(emf);		

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

		System.out.println("Remplissage des données");
		
		//Matières
		Matiere m1 = new Matiere("Maths");
		Matiere m2 = new Matiere("Physique");
		Matiere m3 = new Matiere("Français");
		Matiere m4 = new Matiere("Anglais");
		Matiere m5 = new Matiere("EPS");
		
		em.persist(m1); em.persist(m2); em.persist(m3); em.persist(m4); em.persist(m5);
		
		//Etudiants
		String[] prenoms = new String[] {"Sylva", "Aude", "Anne", "Marc", "Samson", "Gilles", "Laura"}; //Froid
		
		Random rng = new Random();
		
		for (int i=1; i<=40; i++)
		{
			String nom = prenoms[rng.nextInt(prenoms.length)];
			Etudiant e = new Etudiant(nom+i, nom+i+"@etudiants.loncoto.com");
			em.persist(e);			
		}
		
		//Formateurs

		for (int i=1; i<=4; i++)
		{
			String nom = prenoms[rng.nextInt(prenoms.length)];
			Formateur f = new Formateur("NOM"+i, nom+i);
			em.persist(f);			
		}
		
		//Cours
		
		for (int i=1; i<=20; i++)
		{
			Date d = new Date(115, 06, rng.nextInt(31), rng.nextInt(8)+8, 0);
			Date f = new Date(d.getYear(), d.getMonth(), d.getDay(), d.getHours()+1, 0);
			
			Matiere m = em.find(Matiere.class, rng.nextInt(5)+1);
			Formateur forma = em.find(Formateur.class, rng.nextInt(4)+1);
			
			Cours c = new Cours(d, f, m.getDenomination()+i, m, forma);
			
			em.persist(c);
			
			for (int j=1; j<=rng.nextInt(5)+5; j++)
			{
				c.addEtudiant(em.find(Etudiant.class, rng.nextInt(40)+1));
			}
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

		System.out.println("lister les etudiants et les dates et matieres de leur cours");
		
		Query query = em.createQuery("select etud from Etudiant as etud left join fetch etud.cours");
		
		List<Etudiant> liste = query.getResultList();
		
		for (Etudiant e : liste)
		{
			System.out.println(e);
			
			for (Cours c : e.getCours())
			{
				System.out.println(c);
			}
		}
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}


	public static void test3(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------

		System.out.println("lister les matieres et les cours correspondant");
		
		Query query = em.createQuery("select mat from Matiere as mat left join fetch mat.cours");
		
		List<Matiere> result = query.getResultList();
		
		for (Matiere m : result)
		{
			System.out.println(m);
			for (Cours c : m.getCours())
				System.out.println(c);
		}
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}
	
}
