

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Accueil eBoutique</title>
</head>

<body>

	<h2>Bienvenue sur votre page d'accueil</h2>
	
	<p class="text-left">Vous êtes connectés</p>
	<p> Cliquez sur le lien pour accéder au <a href="<c:url value="/catalogueservlet"/>">catalogue</a> : <br/> </p>
	
</body>

</html>