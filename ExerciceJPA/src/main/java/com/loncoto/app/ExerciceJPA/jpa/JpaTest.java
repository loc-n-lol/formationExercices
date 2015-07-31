package com.loncoto.app.ExerciceJPA.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.loncoto.app.ExerciceJPA.beans.Employe;
import com.loncoto.app.ExerciceJPA.beans.Service;
import com.loncoto.app.ExerciceJPA.beans.Site;

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
		test4(emf);		
		
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

		
		Site site1 = new Site("site1", "ici");
		Site site2 = new Site("site2", "la-bas");
		Site site3 = new Site("site3", "ailleurs");
		
		em.persist(site1); em.persist(site2); em.persist(site3);
		
		Service serv1 = new Service("service1", null, site1);
		Service serv2 = new Service("service2", null, site1);
		Service serv3 = new Service("service3", null, site2);
		Service serv4 = new Service("service4", null, site2);
		Service serv5 = new Service("service5", null, site2);
		Service serv6 = new Service("service6", null, site3);
		Service serv7 = new Service("service7", null, site3);
		
		em.persist(serv1); em.persist(serv2); em.persist(serv3); em.persist(serv4);
		em.persist(serv5); em.persist(serv6); em.persist(serv7);
		
		Employe manager1 = new Employe("Manager1", "manager1@loncoto.com", 45000, serv1);
		Employe manager2 = new Employe("Manager2", "manager2@loncoto.com", 48000, serv3);
		Employe manager3 = new Employe("Manager3", "manager3@loncoto.com", 54000, serv5);
		
		serv1.setManager(manager1);
		serv2.setManager(manager1);
		serv3.setManager(manager2);
		serv4.setManager(manager2);
		serv5.setManager(manager3);
		serv6.setManager(manager3);
		serv7.setManager(manager3);
		
		em.persist(manager1); em.persist(manager2); em.persist(manager3);
		
		for (int i=1; i<=40; i++)
		{
			Employe e = new Employe("Employe"+i, "employe"+i+"@loncoto.com", 
					(int)((Math.random()+1)*18000), 
					em.find(Service.class, (int)(Math.random() * 7 + 1))); 
			
			em.persist(e);
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
		System.out.println("requetter les Employe :");
		Query query = em.createQuery("from Employe");
		List<Employe> employes = query.getResultList();
		for (Employe e : employes)
		{
			System.out.println(e);
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
		System.out.println("requetter un service et liste ses employe :");	
		
		Service service = em.find(Service.class, (int)(Math.random() * 7 + 1));
		System.out.println(service);
		
		Set<Employe> employes = service.getMesEmployes();
		
		for (Employe e : employes)
		{
			System.out.println(e);
		}

		//----------------------------------------------------
		tx.commit();
		em.close();
	}	

	
	public static void test4(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		System.out.println("lister les employe d'un service dont le salaire est supérieur a une certaine valeur :");	
		
		Service service = em.find(Service.class, (int)(Math.random() * 7 + 1));
		System.out.println(service);
		
		
		Query query = em.createQuery("select empl from Employe as empl where empl.salaire > :certaine_valeur and empl.service = :service");
		
		query.setParameter("certaine_valeur", 30000);
		query.setParameter("service", service);
		
		List<Employe> employes = query.getResultList();
		
		for (Employe e : employes)
		{
			System.out.println(e);
		}

		//----------------------------------------------------
		tx.commit();
		em.close();
	}		
	
}
