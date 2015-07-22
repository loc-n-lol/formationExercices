package tagannotations.tags;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import tagannotations.annotations.ChampFormulaire;
import tagannotations.beans.Article;

public class MyForm extends SimpleTagSupport {

	public String action;
	public String item;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public void doTag() throws JspException, IOException {

		System.out.println("doTag()");
		
		super.doTag();
		
		PageContext pc = (PageContext)getJspContext();
		JspWriter writer = pc.getOut();
		
		ServletRequest req = pc.getRequest();

		writer.println("<form action='"+action+"' method='post'>");

		Class cls = (Class)req.getAttribute(item);
		
		for (Field f : cls.getFields())
		{
			ChampFormulaire cf =  f.getAnnotation(ChampFormulaire.class);
			writer.println(cf.label()+": <input type='text' name='"+cf.name()+"'/><br/>");
		}	
		
		writer.println("<input type='submit' value='Envoyer'>");
		writer.println("</form>");
	}

}
