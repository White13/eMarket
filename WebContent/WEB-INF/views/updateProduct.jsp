<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>

		<form action="UpdateServlet" method="post">
			<table>
				<tr>
					<td><label>id du produit :</label></td>
					<td><input name="id" type="text" /></td>
				</tr>
				
				<tr>
					<td><label> Nouveau prix : </label></td>
					<td><input name="sellingPrice" type="text" /></td>
				</tr>
				<tr/>
				<tr/>
				<tr>
				<td><input type="submit" value="Valider"/></td>
				</tr>
			</table>
			</form>
	</div>
</body>
</html>