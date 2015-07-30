package com.limpoto.webapps.SecondJsf2.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IndexBean 
{
	private String nom, password;
	
	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}


	public IndexBean() {
		System.out.println("Construction de IndexBean");
	}
	
	@ManagedProperty(value="#{userStore}")
	private UserStore myStore;
	
	public UserStore getMyStore() {return myStore;}
	public void setMyStore(UserStore myStore) {
		System.out.println("Injection du UserStore dans IndexBean");
		this.myStore = myStore;
		
	}


	public String login() {
		
		if (myStore.verifyLogin(getNom(), getPassword()))
			return "success";
		else
			return "error";
		
		/*
		if (getPassword().length() < 3 || getPassword().length() > 30)
			return "error";
		else
			return "success";
			*/
	}
	
}
