package com.loncoto.webapps.ExerciceSpringPlusPlus.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Intervention;

public class InterventionDAO implements IInterventionDAO {

	@PersistenceContext
	private EntityManager em;	
	
	@Override
	@Transactional
	public Intervention find(int id)
	{
		return em.find(Intervention.class, id);
	}

	@Override
	@Transactional
	public List<Intervention> findAll()
	{
		return em.createQuery("from Intervention", Intervention.class).getResultList();
	}

	@Override
	@Transactional
	public Intervention save(Intervention i)
	{
		if (i.getId() == 0 || em.find(Intervention.class, i.getId()) == null)
		{
			em.persist(i);
			return i;
		}
		else			
			return em.merge(i);
	}

	@Override
	@Transactional
	public boolean delete(int id)
	{
		Intervention i = em.find(Intervention.class, id);
		
		if (i == null)
			return false;
		else
		{
			em.remove(i);
			return true;
		}
	}
	
}
