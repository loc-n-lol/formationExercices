package com.loncoto.webapps.ExerciceSpringPlusPlus.metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Intervention implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date datePlanification;
	private String memo, statut;
	private Intervenant intervenant;
	private Materiel materiel;
	
	@Id @GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	@Temporal(TemporalType.DATE)
	public Date getDatePlanification() {return datePlanification;}
	public void setDatePlanification(Date datePlanification) {this.datePlanification = datePlanification;}
	
	public String getMemo() {return memo;}
	public void setMemo(String memo) {this.memo = memo;}
	public String getStatut() {return statut;}
	public void setStatut(String statut) {this.statut = statut;}
	
	@ManyToOne
	public Intervenant getIntervenant() {return intervenant;}
	public void setIntervenant(Intervenant intervenant) {this.intervenant = intervenant;}
	@ManyToOne
	public Materiel getMateriel() {return materiel;}
	public void setMateriel(Materiel materiel) {this.materiel = materiel;}
	
	public Intervention(){}
	
	public Intervention(int id, Date datePlanification, String memo,
			String statut, Intervenant intervenant, Materiel materiel) {
		super();
		this.id = id;
		this.datePlanification = datePlanification;
		this.memo = memo;
		this.statut = statut;
		this.intervenant = intervenant;
		this.materiel = materiel;
	}
	
	
	
	
}
