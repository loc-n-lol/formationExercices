<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout / Modification</title>
</head>
<body>
<jsp:useBean id="article" type="beans.Article" scope="request" />
	<form action="catalogue" method="post">
		<input type="hidden" name="id"
			value='<jsp:getProperty property="id" name="article"/>' /> <br/>
		libelle:<input type="text" name="libelle"
			value='<jsp:getProperty property="libelle" name="article"/>' /> <br/>
		prix:<input type="text" name="prix"
			value='<jsp:getProperty property="prix" name="article"/>' />  <br/>
		poids:<input type="text" name="poids"
			value='<jsp:getProperty property="poids" name="article"/>' /> <br/>
		<input type="submit" name="action" value="enregistrer" />
	</form>

</body>
</html>