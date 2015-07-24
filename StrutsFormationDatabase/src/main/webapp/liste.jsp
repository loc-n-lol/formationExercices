<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>liste des clients</title>
</head>
<body>
	<h2>liste des clients</h2>
	<table boder="2">
		<tr>
			<th>nom</th>
			<th>email</th>
			<th>actions</th>
		</tr>
		<s:iterator value="clients">
			<tr>
				<td><s:property value="nom" /></td>
				<td><s:property value="email" /></td>
				<td><s:property value="solde" /></td>
				<td>actions...</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>