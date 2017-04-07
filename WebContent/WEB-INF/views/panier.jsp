<%@ include file="header.jsp"%>
<body>

	<h1>PANIER</h1>

	<div class="container">
		<div class="row">

			<div class="col-xs-3 libelle">Libelle</div>
			<div class="col-xs-1"></div>
			<div class="col-xs-2">Quantite</div>
			<div class="col-xs-1"></div>
			<div class="col-xs-1 ">Prix Unitaire</div>
			<div class="col-xs-1 ">Prix Total</div>

		</div>
		<div class="row">
			<br />
		</div>
		<div id="listProduct"></div>

		<div class="row">
			<br />
		</div>
		<div class="row">
			<div class="col-xs-3 pull-right" id="prixTotal" data-total="0"></div>
			<div>
				<button class="btn btn-primary pull-right" id="validationPanier">Valider
					Commande</button>
			</div>
		</div>
	</div>
	

	<div id="template" class="hide">
		<div class="modele">
			<div class="row">
				<div class="col-xs-3 libelle"></div>
				<div class="col-xs-1"><button class=" buttonIncrDecr btn btn-info btn-lg glyphicon glyphicon-minus-sign" data-id="moins"></button></div>
				<div class="col-xs-2"><input type="text" class="qtteProduct form-control" /></div>
				
				<div class="col-xs-1"><button class=" buttonIncrDecr btn btn-info btn-lg glyphicon glyphicon-plus-sign" data-id="plus"></button></div>			
				<div class="col-xs-1 prixUnite">Prix</div>
				<div class="col-xs-1 prixSubtotal">Prix</div>
				<div class="col-xs-1"><button class="idProduct btn btn-info btn-lg glyphicon glyphicon-remove-sign"></button></div>
			</div>
		</div>
	</div>



	<script src="js/jquery.js"></script>
	<script src="js/jquery.cookie.js"></script>

	<script>
		jQuery(function($) {
			
		
			$.cookie.json = true;
			//var produitPanier = $.cookie("panier") || {};

			var panier = $.cookie("panier"); //|| {};
			var numLigne = 0;
			var total = 0;

			if (panier == null) {
				console.log("null");
			} else {

				for (idProduct in panier) {

					//	var id = panier[idProduct].id;
					var nom = panier[idProduct].nom;
					var prix = panier[idProduct].prix;
					var qtte = panier[idProduct].quantity;
					var subtotal = parseFloat(prix * qtte);

					total += subtotal;

					$("#template").find(".modele").clone().appendTo("#listProduct");
					var ligne = $("#listProduct").find(".modele").eq(numLigne);

					ligne.find(".libelle").text(nom);
					ligne.find(".qtteProduct").val(qtte);
					ligne.find(".prixUnite").text(prix);
					ligne.find(".prixSubtotal").text(subtotal);
					ligne.find(".idProduct").attr("data-id", idProduct);

					numLigne++;
				}
				$("#prixTotal").attr("data-total", total).text(total + " euros");
			}

			$(".buttonIncrDecr").click(function() {
						//var prixttc = $(this).parents(".modele").text(".prixProduct");
						
						//var qt = $(this).parents(".modele").find(".qtteProduct");
						
						var valeur = parseInt($(this).parents(".modele").find(".qtteProduct").val());
						var prix = parseFloat($(this).parents(".modele").find(".prixUnite").text());					
						var total = parseFloat($("#prixTotal").attr("data-total"));
						
						
						var operation = 1;
						
						
						if ($(this).data("id") == "moins") {
							operation = (valeur - 1 < 1) ? 0 : -1;
						}
						valeur += operation;
						total += operation * prix;
						var subtotal = prix * valeur;
						
						
						$(this).parents(".modele").find(".qtteProduct").val(valeur);
						$(this).parents(".modele").find(".prixSubtotal").text(subtotal);
						$("#prixTotal").attr("data-total", total).text("total: " + total);
						
						var panier = $.cookie("panier");
						var idProduct = $(this).parents(".modele").find(".idProduct").attr("data-id");
						panier[idProduct].quantity = valeur;
						$.cookie("panier", panier);
			});

			
			
			$(".idProduct").click(
					function() {
						
						var panier = $.cookie("panier");
						var idProduct = $(this).attr("data-id");
						var subtotal = panier[idProduct].prix * panier[idProduct].quantity;
						var total = parseFloat($("#prixTotal").attr("data-total"));

						total -= subtotal;

						delete panier[idProduct];
						$.cookie("panier", panier);
						$(this).parents(".modele").remove();
						$("#prixTotal").attr("data-total", total).text(total + " euros");
			});
			
			$(".qtteProduct").keypress(function(e) {
				
				if(e.which > 47 && e.which < 58) {
					return true;
				}
				return false;
				// return e.which > 47 && e.which < 58 
			});
			
			$(".qtteProduct").keyup(function() {
				
				if($(this).val() != "") {
					
				var subtotal = parseFloat($(this).parents(".modele").find(".prixSubtotal").text());
				var prixtotal = parseFloat($("#prixTotal").attr("data-total"));
				var quantite = parseInt($(this).val());
				var prixUnitaire = parseFloat($(this).parents(".modele").find(".prixUnite").text());	
	
				var newsubtotal = quantite * prixUnitaire;
				var diff = newsubtotal - subtotal;
				
				prixtotal += diff;
				
				var panier = $.cookie("panier");
				var idProduct = $(this).parents(".modele").find(".idProduct").attr("data-id");
				panier[idProduct].quantity = quantite;
				$.cookie("panier", panier);
			
				$(this).parents(".modele").find(".prixSubtotal").text(newsubtotal);
				$("#prixTotal").attr("data-total", prixtotal).text("total: " + prixtotal);
				
				}
			});
			
			
			$("#validationPanier").click(function() {
				$.cookie("panier", panier);
				
				$.post("ValiderPanierServlet", {"panier" : JSON.stringify(panier)}, function(response){
					if (response == "OK") {
						console.log("le panier est valider")
					} else {
						
					}
				});
			});		

		});
	</script>
</body>

</html>