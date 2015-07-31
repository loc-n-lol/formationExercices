package com.loncoto.app.ExerciceJPA.beans;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Service {

	private int id;

	private String denomination;
	private Employe manager;
	private Site site;
	private Set<Employe> mesEmployes;
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	@ManyToOne
	public Employe getManager() {
		return manager;
	}
	public void setManager(Employe manager) {
		this.manager = manager;
	}
	
	@ManyToOne
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	@OneToMany(mappedBy="service")
	public Set<Employe> getMesEmployes() {
		return mesEmployes;
	}
	public void setMesEmployes(Set<Employe> mesEmployes) {
		this.mesEmployes = mesEmployes;
	}
	
	public Service() { this("", null, null); }
	
	public Service(String denomination, Employe manager, Site site) {
		super();
		this.denomination = denomination;
		this.manager = manager;
		this.site = site;
	}
	
	@Override
	public String toString() {
		return "Service [id=" + id + ", denomination=" + denomination
				+ ", manager=" + manager.getNom() + ", site=" + site.getNom() + "]";
	}

	
}
