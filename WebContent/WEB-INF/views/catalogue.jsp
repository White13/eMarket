
<%@ include file="header.jsp"%>
<style>
table, th, td {
	border: 1px solid black;
}
</style>

<body>

	<h1 style="width: 50%">Liste des Produits disponibles</h1>

	<c:choose>

		<c:when test="${empty product}">Pas de données</c:when>
		<c:otherwise>
			<table style="width: 50%">

				<thead>
					<tr>
						<th style="text-align: center">Id</th>
						<th style="text-align: center">PRODUIT</th>
						<th style="text-align: center">Prix</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${product}" var="prod">
						<tr>
							<td style="text-align: center;" id="idproduct">${prod.id}</td>
							<td class="nameProduct" data-idProduct="${prod.id}"
								style="text-align: center; cursor: pointer">${prod.name}</td>
							<td style="text-align: center;">${prod.sellingPrice}</td>
						</tr>
					
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>

	</c:choose>
	<form action="detailsServlet" method="Post">
		<input type="hidden" name="idProduct" id="frmIdProduct">
	</form>

	<script src="js/jquery.js"></script>
	<script>
		jQuery(function($) {
			if ($(".nameProduct")) {
				$(".nameProduct").bind('click', function() {
					alert($(this).attr("data-idProduct"));
					$("#frmIdProduct").val($(this).attr("data-idProduct"));
					$("form").submit();
				});
			}
		});
	</script>
</body>

</html>