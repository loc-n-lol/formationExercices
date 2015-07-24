<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edition article</title>
</head>
<body>
<h2>edition article</h2>
<s:form action="enregistrer" method="post">
<s:hidden name="id" />
<s:textfield name="libelle" label="Nom article" />
<s:textfield name="prix" label="Prix article" />
<s:textfield name="poids" label="Poids article" />
<s:submit value="sauver"/>
</s:form>
</body>
</html>