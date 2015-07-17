<%@page import="beans.Article"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste d'articles</title>
</head>
<body>
	<table border="2">
		<tr>
			<th>ID</th>
			<th>Libellé</th>
			<th>Prix</th>
			<th>Poids</th>
		</tr>
		<%
		Vector<Article> vec = (Vector<Article>) request.getAttribute("articles");
		
		for (Article a : vec) { %>
		<tr>
			<td><%= a.getId() %></td>
			<td><%= a.getLibelle() %></td>
			<td><%= a.getPrix() %></td>
			<td><%= a.getPoids() %></td>
			<td>
				<form action="catalogue" method="post" >
					<input type="hidden" name="id" value="<%= a.getId() %>" />
					<input type="submit" name="action" value="modifier"/>
				</form>
			</td>
			<td>
				<form action="catalogue" method="post" >
					<input type="hidden" name="id" value="<%= a.getId() %>" />
					<input type="submit" name="action" value="supprimer"/>
				</form>
			</td>
		</tr>
		<% } %>
	</table>
	<form action="catalogue" method="post" >
		<input type="submit" name="action" value="ajouter"/>
	</form>
</body>
</html>