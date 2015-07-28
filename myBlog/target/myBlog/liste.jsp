<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Blog</title>
</head>
<body>
<s:iterator value="posts">
<h2>
<span><s:property value="id"/></span>
<s:property value="titre"/>
</h2>
<p><s:property value="corps"/></p>
<p><s:property value="dateCreation"/></p>
<s:a action="editer/%{id}">modifier</s:a>
<hr/>
</s:iterator>
<s:a action="creer">créer</s:a>
</body>
</html>