

<%@ include file="header.jsp"%>
 
<body>

	<table style="width: 50%">

		<thead>
			<tr>
				<th>ID</th>
				<th>DESCRIPTION</th>
				<th>PRODUIT</th>
				<th>PRIX</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td id="idproduct">${details[0]}</td>
				<td id="descript">${details[1]}</td>
				<td id="name_prod">${details[2]}</td>
				<td id="price">${details[3]}</td>
			</tr>
		</tbody>
	</table>

	<h4>Composants</h4>

	<div class="row">
		<c:forEach items="${details}" var="detail" begin="4" step="5">
			<div class="col-xs-3">
				<div class="alert alert-info">${detail}</div>
			</div>
		</c:forEach>
	</div>


	<div class="row">
		<div class="pull-right">
			<div class="col-xs-1">
				<button class="buttonIncrDecr btn btn-primary" id="moins">-</button>
			</div>
			<div class="col-xs-3">
				<input type="text" class=" form-control" value="1" id="qttePanier" />
			</div>
			<div class="col-xs-1">
				<button class="buttonIncrDecr btn btn-primary" id="plus">+</button>
			</div>
		</div>
		<div>
			<button class="btn btn-primary pull-right" id="ajoutpanier">Ajouter	au panier</button>
		</div>
		<div><button class="btn btn-warning"><span class="glyphicon  glyphicon-shopping-cart" id="voirpanier"></span> Voir le panier</button> </div>   </br></br>
		
	</div>
<div class="pull-right">
<button href="/catalogueservlet">Retour au catalogue</button>
</div>

	<script src="js/jquery.js"></script>
	<script src="js/jquery.cookie.js"></script>
	
	<script>
	
		jQuery(function($) {
			$.cookie.json = true;
			
			$("#qttePanier").keypress(function(e) {
							
				if(e.which > 47 && e.which < 58) {
					return true;
				}
				return false;
				// return e.which > 47 && e.which < 58 
			});
			
			$("#ajoutpanier").click(function() {			
				
				var produitPanier = $.cookie("panier") || {};
				
				var id = $("#idproduct").text();
				var valeur = parseInt($("#qttePanier").val());
				
				if(produitPanier[id]){
					valeur += produitPanier[id].quantity;
						
				}
				
				var product = {
					nom : $("#name_prod").text(),
					prix : parseFloat($("#price").text()),
					quantity : valeur,
					idproduct : id,
				}
				
				produitPanier[id] = product;
				
				$.cookie("panier", produitPanier);
				
				window.location.href="http://localhost:8080/centraleAchats/panier";
			});
			
			$(".buttonIncrDecr").click(function() {

				var operation = 1;
				var valeur = parseInt($("#qttePanier").val());

				if ($(this).attr("id") == "moins") {
					operation = (valeur - 1 < 1) ? 0 : -1;
				}
				valeur += operation;
				$("#qttePanier").val(valeur);

			});
			
			
			
			
			
		
		});
		
	</script>

</body>

</html>