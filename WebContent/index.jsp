<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>eBoutique</title>

</head>
<!-- header -->

<body>


<c:if test="${error}">
<div class="alert alert-danger">
Vos identifiants sont incorrects
</div>
</c:if>
	
	<div class="container">
	<div class="row">
	<div class="col-xs-12">
    
    <div class="main">
            
        <div class="row">
        <div class="col-xs-12 col-sm-6 col-sm-offset-1">
                    
            <h1>Connection</h1>
           
                    
            <form action="ConnectionServlet" name="login" role="form" class="form-horizontal" method="post" accept-charset="utf-8">
            
                <div class="form-group">
                <div class="col-md-8"><input name="login" placeholder="Identifiant" class="form-control" type="text" id="Login"/></div>
                </div> 
                
                <div class="form-group">
                <div class="col-md-8"><input name="pwd" placeholder="Mot de passe" class="form-control" type="password" id="UserPassword" accept-charset="utf-8"/></div>
                </div> 
                
                <div class="checkbox">
        		<div><label>  <input type="checkbox"> Se rappeller de moi</label></div>
      			
                <div></div>
                <div class="form-group">
                <div class="col-md-offset-0 col-md-8"><input  class="btn btn-success btn btn-success" type="submit" value="Connexion"/></div>
                </div>
                
            </form>
            
        </div>
        </div>
        
    </div>
</div>
</div>
</div>
	

</body>
 
</html>