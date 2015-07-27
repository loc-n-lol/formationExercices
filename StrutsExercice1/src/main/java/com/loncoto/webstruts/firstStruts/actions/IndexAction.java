package com.loncoto.webstruts.firstStruts.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;

	private String message;
	private String login;
	private String password;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
// GET/SET
//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
// ACTIONS
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String index() {
		message = "Connection:";
		return SUCCESS;
	}
	
	public String login() {
		if (password.length() < 3)
		{
			message = "mot de passe trop court";
			return ERROR;
		}
		else
		{
			message = "Bienvenue, "+login;
			return SUCCESS;
		}
	}

	
}
