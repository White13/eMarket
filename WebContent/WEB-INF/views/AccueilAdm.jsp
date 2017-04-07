

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Accueil eBoutique Administrateur</title>
</head>


<body>
		
	<a href="<c:url value="/createProductservlet"/>"> Créer un Produit</a> 

	<p> pour accéder au <a href="<c:url value="/catalogueservlet"/>">catalogue</a> : <br/> </p>

	<p> pour supprimer un produit du catalogue : <br/> </p>

	<button><a href="<c:url value="/deleteProductservlet"/>"> Supprimer un produit</a> </button>
	
	<p> pour modifier un produit du catalogue : <br/> </p>

	<a href="<c:url value="/UpdateServlet"/>"> modifier un produit</a> 
	
	<a href="#" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-plus-sign"></span> Plus
        </a>
        
        <a href="#" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-minus-sign"></span> Moins
        </a>
        
        <a href="#" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-remove-sign"></span> Remove
        </a>
	
</body>

</html>