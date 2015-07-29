package com.limpoto.webapps.myBlog.util;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;

public class RSSResult implements Result {

	private String channelTitle;
	private String channelDescription;
	private String channelLink;
	private String itemCollection;
	private String itemTitle;
	private String itemDescription;
	
	public String getChannelTitle() {return channelTitle;}
	public void setChannelTitle(String channelTitle) {this.channelTitle = channelTitle;}
	public String getChannelDescription() {return channelDescription;}
	public void setChannelDescription(String channelDescription) {this.channelDescription = channelDescription;}
	public String getChannelLink() {return channelLink;}
	public void setChannelLink(String channelLink) {this.channelLink = channelLink;}
	public String getItemCollection() {return itemCollection;}
	public void setItemCollection(String itemCollection) {this.itemCollection = itemCollection;}
	public String getItemTitle() {return itemTitle;}
	public void setItemTitle(String itemTitle) {this.itemTitle = itemTitle;}
	public String getItemDescription() {return itemDescription;}
	public void setItemDescription(String itemDescription) {this.itemDescription = itemDescription;}

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		
		//JE récupère la valuestack qui contirndra les données préparées par l'action
		ValueStack vs = invocation.getStack();
		
		//Je récupère l'objet réponse via lequel j'écrirais mon flux RSS
		HttpServletResponse response = ServletActionContext.getResponse();
		
		PrintWriter pw = response.getWriter();
		
		response.setContentType("application/xml");
		pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		pw.println("<rss version=\"2.0\">");
		pw.println("<channel>");
		pw.println("<title>" + getChannelTitle() + "</title>");
		
		System.out.println(getItemCollection());
		Iterable items = (Iterable)vs.findValue(getItemCollection());
		
		for (Object item : items)
		{
			pw.println("<item>");
			
			Class cls = item.getClass();
			
			//itemTitle=="titre" -> getMethod : "get" + "T" + "itre"
			Method mtitle = cls.getMethod("get"
					+ getItemTitle().substring(0, 1).toUpperCase()
					+ getItemTitle().substring(1));
			
			Object titleValue = mtitle.invoke(item);
			
			Method mdescription = cls.getMethod("get"
					+ getItemDescription().substring(0, 1).toUpperCase()
					+ getItemDescription().substring(1));
			
			Object descriptionValue = mdescription.invoke(item);
			
			pw.println("</item>");
		}
		
		pw.println("</channel>");
		pw.println("</rss>");
	}

}
