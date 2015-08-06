package com.loncoto.webapps.ExerciceSpringPlusPlus.actions;

import java.util.Date;
import java.util.List;

import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Intervenant;
import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Intervention;
import com.loncoto.webapps.ExerciceSpringPlusPlus.metier.Materiel;
import com.loncoto.webapps.ExerciceSpringPlusPlus.models.IIntervenantDAO;
import com.loncoto.webapps.ExerciceSpringPlusPlus.models.IInterventionDAO;
import com.loncoto.webapps.ExerciceSpringPlusPlus.models.IMaterielDAO;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private String message;
	
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
	
	
	private IInterventionDAO interventionDAO;
	private IMaterielDAO materielDAO;
	private IIntervenantDAO intervenantDAO;
	
	public IInterventionDAO getInterventionDAO() {return interventionDAO;}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		System.out.println("Injection du InterventionDAO par Spring");
		this.interventionDAO = interventionDAO;
	}
	public IMaterielDAO getMaterielDAO() {return materielDAO;}
	public void setMaterielDAO(IMaterielDAO materielDAO) {
		System.out.println("Injection du MaterielDAO par Spring");
		this.materielDAO = materielDAO;
	}
	public IIntervenantDAO getIntervenantDAO() {return intervenantDAO;}
	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {
		System.out.println("Injection du IntervenantDAO par Spring");
		this.intervenantDAO = intervenantDAO;
	}	
	
	private List<Intervention> listeInterventions;
	private List<Materiel> listeMateriels;
	private List<Intervenant> listeIntervenants;
	
	private int id, intervenantId, materielId;
	private Date datePlanification;
	private String memo, statut;
	private Intervenant intervenant;
	private Materiel materiel;
	
	public List<Intervention> getListeInterventions() {return listeInterventions;}
	public void setListeInterventions(List<Intervention> listeInterventions) {this.listeInterventions = listeInterventions;}		
	public List<Intervenant> getListeIntervenants() {return listeIntervenants;}
	public void setListeIntervenants(List<Intervenant> listeIntervenants) {this.listeIntervenants = listeIntervenants;}
	public List<Materiel> getListeMateriels() {return listeMateriels;}
	public void setListeMateriels(List<Materiel> listeMateriels) {this.listeMateriels = listeMateriels;}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public Date getDatePlanification() {return datePlanification;}
	public void setDatePlanification(Date datePlanification) {this.datePlanification = datePlanification;}
	public String getMemo() {return memo;}
	public void setMemo(String memo) {this.memo = memo;}
	public String getStatut() {return statut;}
	public void setStatut(String statut) {this.statut = statut;}
	public Intervenant getIntervenant() {return intervenant;}
	public void setIntervenant(Intervenant intervenant) {this.intervenant = intervenant;}
	public Materiel getMateriel() {return materiel;}
	public void setMateriel(Materiel materiel) {this.materiel = materiel;}	
	
	public int getIntervenantId() {return intervenantId;}	
	public void setIntervenantId(int intervenantId) {this.intervenantId = intervenantId;}
	public int getMaterielId() {return materielId;}
	public void setMaterielId(int materielId) {this.materielId = materielId;}	
	
	
	public String index() {
		message = "Liste des messages";
		setListeInterventions(getInterventionDAO().findAll());
		
		return SUCCESS;
	}
	
	public String edit() {
		message = "Ajout/Modification de message";

		Intervention intervention = interventionDAO.find(id);
		
		
		
		if (intervention != null)
		{
			setDatePlanification(intervention.getDatePlanification());
			setMemo(intervention.getMemo());
			setStatut(intervention.getStatut());
			setIntervenant(intervention.getIntervenant());
			setMateriel(intervention.getMateriel());
		}
		else
		{
			setDatePlanification(new Date());
			setMemo("");
			setStatut("");
			setIntervenant(null);
			setMateriel(null);
		}
		
		if (intervenant != null)
			setIntervenantId(intervenant.getId());
		else
			setIntervenantId(0);
		
		if (materiel != null)
			setMaterielId(materiel.getId());
		else
			setMaterielId(0);
		
		setListeIntervenants(intervenantDAO.findAll());
		setListeMateriels(materielDAO.findAll());

		return SUCCESS;
	}
	
	public String save() {
		
		setMateriel(materielDAO.find(materielId));
		setIntervenant(intervenantDAO.find(intervenantId));
		getInterventionDAO().save(new Intervention(getId(), getDatePlanification(), getMemo(), getStatut(), getIntervenant(), getMateriel()));

		return SUCCESS;
	}
	
	public String delete() {
		
		getInterventionDAO().delete(getId());

		return SUCCESS;
	}	







}
