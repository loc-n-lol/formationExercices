package com.loncoto.webstruts.firstStruts.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;

	private String message;
	private String nom;
	private int age;
	
	/*
	 * 
	 * GET/SET
	 * 
	 */
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	/*
	 * 
	 * ACTIONS
	 * 
	 */
		
	public String index() {
		message = "bonjour depuis index le " + new Date();
		return SUCCESS;
	}
	
	public String hello()
	{
		if (age < 12)
		{
			message = "Vous être trop jeune, revenez plus tard";
			return ERROR;		
		}
		else
		{
			message = "bienvenue "+nom+" sur notre site boursier";
			return SUCCESS;
		}
	}

}
