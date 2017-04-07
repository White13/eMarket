<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TABLE</title>
</head>
<body>

	<h1>Addition d'un produit</h1>
	<div>
	<form action="createProductservlet" method="post"> 
	<table>
	
		<tr>
		<td><label>Nom :</label></td>
		<td><input name="nom" type="text"/></td>
		</tr>
		
		<tr>
			<td><label>Prix :</label></td>
			<td><input name="sellingPrice" type="text"/></td>
		</tr>
		
		<tr>
		<td><input type="submit" value="create" /></td>
		</tr>
		
	</table>
	</form>
	</div>	
</body>
</html>