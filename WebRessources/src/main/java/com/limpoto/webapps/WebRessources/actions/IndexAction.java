package com.limpoto.webapps.WebRessources.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;

	private String message;
	private String message2;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public String index() {
		message = getText("welcome.message");
		message2 = getText("welcome.message2", new String [] {"vincent", "starbucks"});
		return SUCCESS;
	}


}
