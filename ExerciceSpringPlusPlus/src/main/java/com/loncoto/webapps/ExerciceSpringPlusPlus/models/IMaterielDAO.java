package com.loncoto.webapps.ExerciceSpringPlusPlus.models;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Materiel;

public interface IMaterielDAO {

	Materiel find(int id);

	List<Materiel> findAll();

}