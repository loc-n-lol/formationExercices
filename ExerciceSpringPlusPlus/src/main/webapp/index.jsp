<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste</title>
</head>
<body>
<h2><s:property value="message" /> </h2>

<table border="1">
<tr>
<th>ID</th>
<th>Date de planification</th>
<th>Mémo</th>
<th>Statut</th>
<th>Intervenant</th>
<th>Matériel</th>
<th colspan="2">Actions</th>
</tr>
<s:iterator value="listeInterventions">
<tr>
<td><s:property value="id"/></td>
<td><s:property value="datePlanification"/></td>
<td><s:property value="memo"/></td>
<td><s:property value="statut"/></td>
<td><s:property value="intervenant"/></td>
<td><s:property value="materiel"/></td>
<td><s:a action="edit/%{id}">modifier</s:a></td>
<td><s:a action="delete/%{id}">supprimer</s:a></td>
</tr>
</s:iterator>
</table>

<s:a action="edit/0">Ajouter</s:a>

</body>
</html>