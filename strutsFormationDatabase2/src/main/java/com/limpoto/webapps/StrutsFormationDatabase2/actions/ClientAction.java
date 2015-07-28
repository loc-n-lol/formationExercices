package com.limpoto.webapps.StrutsFormationDatabase2.actions;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.limpoto.webapps.StrutsFormationDatabase2.beans.*;
import com.limpoto.webapps.StrutsFormationDatabase2.utils.*;
import com.opensymphony.xwork2.ActionSupport;

public class ClientAction extends ActionSupport implements ServletContextAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<Client> clients;
	public List<Client> getClients() {return clients;}
	
	private ServletContext ctx;
	private ClientDAO clientDAO;
	
	private int clientId;
	private String clientNom;
	private String clientEmail;
	private double clientSolde;
	
	public String getClientNom() {
		return clientNom;
	}
	public void setClientNom(String clientNom) {this.clientNom = clientNom;}
	public String getClientEmail() {return clientEmail;}
	public void setClientEmail(String clientEmail) {this.clientEmail = clientEmail;}
	public double getClientSolde() {return clientSolde;}
	public void setClientSolde(double clientSolde) {this.clientSolde = clientSolde;}
	public int getClientId() {return clientId;}
	public void setClientId(int clientId) {this.clientId = clientId;}

	public String liste() 
	{
		System.out.println("liste()");
		
		clients = clientDAO.findAll();
		return SUCCESS;
	}
	
	public String edit() {
		
		System.out.println("edit(" + getClientId() + ")");
		
		Client c = clientDAO.findByID(getClientId());
		
		if (c==null)
			return "notfound";
		
		setClientNom(c.getNom());
		setClientEmail(c.getEmail());
		setClientSolde(c.getSolde());
		
		return SUCCESS;
	}
	
	public String save()
	{
		System.out.println("save(" + getClientId() + ")");
		
		if (getClientNom().equals("toto"))
		{
			addFieldError("clientNom", "Vous ne pouvez pas entrer toto");
			addActionError("veuillez entrer des données cohérentes");
			return INPUT;
		}
		
		Client client = new Client(getClientId(), getClientNom(), getClientEmail(), getClientSolde());
		clientDAO.save(client);
		
		return SUCCESS;
	}

	@Override
	public void setServletContext(ServletContext arg0) 
	{
		ctx = arg0;
		clientDAO = (ClientDAO)ctx.getAttribute("clientDAO");
	}


}
