<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edition client</title>
</head>
<body>
	<h2>edition client</h2>
	<s:actionerror/>
	<s:actionmessage/>
	<s:form action="save" method="post">
		<s:hidden name="clientId" />
		<s:textfield name="clientNom" label="nom Client" />
		<s:textfield name="clientEmail" label="email Client" />
		<s:textfield name="clientSolde" label="solde Client" />
		<s:submit  value="sauver" />
	</s:form>
</body>
</html>