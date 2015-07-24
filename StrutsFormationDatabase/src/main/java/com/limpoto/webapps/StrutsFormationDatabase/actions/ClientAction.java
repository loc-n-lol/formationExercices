package com.limpoto.webapps.StrutsFormationDatabase.actions;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.limpoto.webapps.StrutsFormationDatabase.beans.Client;
import com.limpoto.webapps.StrutsFormationDatabase.utils.ClientDAO;
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

	public String liste() 
	{
		clients = clientDAO.findAll();
		return SUCCESS;
	}

	@Override
	public void setServletContext(ServletContext arg0) 
	{
		ctx = arg0;
		clientDAO = (ClientDAO)ctx.getAttribute("clientDAO");
	}

}
