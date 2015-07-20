package com.loncoto.webCustomTag.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MessageTag extends SimpleTagSupport {

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		PageContext pc = (PageContext)getJspContext();
		
		JspWriter writer = pc.getOut();
		
		writer.println("<h2>"+message+"</h2>");
	}

}
