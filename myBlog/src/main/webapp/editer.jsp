<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>myBlog</title>
</head>
<body>
<s:form action="sauver" method="post">
<s:hidden name="id"/>
<s:textfield name="titre" label="Titre" />
<s:textarea name="corps" cols="80"/>
<s:submit value ="sauver" />
</s:form>
</body>
</html>