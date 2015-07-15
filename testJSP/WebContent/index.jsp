<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
private int compteur = 0;

private String inverse(String msg){
	StringBuilder sb = new StringBuilder();
	for (int i=msg.length() - 1 ; i>=0 ; i--)
	{
		sb.append(msg.charAt(i));
	}
	
	return sb.toString();
}
%>
<h2>titre: <%= config.getInitParameter("titre") %></h2>
<p>
<%= inverse(new Date().toString()) %>
<%
out.println("<ul>");
for (int i=0; i<10; i++)
{
	out.println("<li>"+i+"</li>");
}
out.println("</ul>");
%>
</p>
<p>
<%
compteur++;
out.println("compteur = "+compteur);
%>
</p>
</body>
</html>