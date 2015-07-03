<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenue sur loncoto</title>
</head>
<body>
	<h2>Nous sommes le <%= new Date()%></h2>

<form action="Home" method = "post">
votre nom: <input type="text" name="nom" id="nom" /> <br/>
votre mpd: <input type="password" name="mdp" id="mdp" /> <br/>
<input type="submit" value="se connecter"/> <br/>
</form>

<ul>
<% for (int i=1 ; i<10; i++) {%>
<li>choix <%= i %></li>
<% } %>
</ul>
<ol>
<% for (int i=1 ; i<10; i++) {
	out.println("<li>"+ i +"</li>");
} %>
</ol>
</body>
</html>