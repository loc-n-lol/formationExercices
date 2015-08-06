package com.loncoto.webapps.ExerciceSpringPlusPlus.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Intervention;
import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Materiel;

public class MaterielDAO implements IMaterielDAO {

	@PersistenceContext
	private EntityManager em;	
	

	@Override
	@Transactional
	public Materiel find(int id)
	{
		return em.find(Materiel.class, id);
	}
	
	@Override
	@Transactional
	public List<Materiel> findAll()
	{
		return em.createQuery("from Materiel", Materiel.class).getResultList();
	}	
	
}
