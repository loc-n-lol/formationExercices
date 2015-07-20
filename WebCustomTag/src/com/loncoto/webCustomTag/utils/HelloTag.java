package com.loncoto.webCustomTag.utils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class HelloTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		PageContext pc = (PageContext)getJspContext();
		
		JspWriter writer = pc.getOut();
		
		writer.println("<h3>Bonjour! Nous sommes le "+new Date()+"</h3>");
	}

}
