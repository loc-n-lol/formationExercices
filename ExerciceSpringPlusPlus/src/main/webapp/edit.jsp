<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2><s:property value="message" /></h2>

<s:form action="save" method="post">
	<s:hidden name="id" value="%{id}" />
	<s:textfield name="datePlanification" value="%{datePlanification}" label="Date Planification"/>
	<s:textarea name="memo" value="%{memo}" label="Description" cols="80" rows="5"/>
	<s:textfield name="statut" value="%{statut}" label="Statut" />
	<s:select name="intervenantId" label="Intervenant" list="listeIntervenants" listKey="id" listValue="nom"/>
	<s:select name="materielId" label="Materiel" list="listeMateriels" listKey="id"/>
	<s:submit />
</s:form>

</body>
</html>