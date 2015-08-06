package com.loncoto.webapps.ExerciceSpringPlusPlus.models;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Intervenant;

public interface IIntervenantDAO {

	Intervenant find(int id);

	List<Intervenant> findAll();

}