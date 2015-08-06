package com.loncoto.webapps.ExerciceSpringPlusPlus.models;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Intervention;

public interface IInterventionDAO {

	public abstract Intervention find(int id);

	public abstract List<Intervention> findAll();

	public abstract Intervention save(Intervention i);

	public abstract boolean delete(int id);

}