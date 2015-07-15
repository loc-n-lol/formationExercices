<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/<%= request.getAttribute("style") %>" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Triangle</title>
</head>
<body>
	<h2 id="titrePage">Triangle de taille <%= request.getAttribute("dimension") %></h2>
	<a href="index.html">retour</a>
	<table>
		<% int dimension = (int)request.getAttribute("dimension");
		for (int ligne=0; ligne < dimension ; ligne++ ) { %>
		<tr>
			<% for (int colonne=0; colonne < dimension - ligne ; colonne++ ) { 

				out.print((colonne == 0 || ligne == 0 || colonne == dimension - ligne - 1) ? 
					"<td class=\"bord\">*</td>" 
					: 
					"<td class=\"cellule\">°</td>"
					); 
			} %>
		</tr>
		<% } %>
	</table>
</body>
</html>