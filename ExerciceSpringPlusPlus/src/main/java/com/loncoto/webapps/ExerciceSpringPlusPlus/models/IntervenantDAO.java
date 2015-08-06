package com.loncoto.webapps.ExerciceSpringPlusPlus.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Intervenant;
import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Materiel;

public class IntervenantDAO implements IIntervenantDAO {

	@PersistenceContext
	private EntityManager em;	
	

	@Override
	@Transactional
	public Intervenant find(int id)
	{
		return em.find(Intervenant.class, id);
	}
	
	@Override
	@Transactional
	public List<Intervenant> findAll()
	{
		return em.createQuery("from Intervenant", Intervenant.class).getResultList();
	}		
	
}
