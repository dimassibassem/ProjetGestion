<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Ajout d'un nouveau produit</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<h1>Ajouter un nouveau Produit</h1>
	<form method="post" action="addProduit">
			<div class="mb-3 mt-3">
				<label for="nom" class="form-label">Nom :</label> 
				<input type="text" class="form-control" id="nom" name="nom" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="prix" class="form-label">Prix :</label> 
				<input type="number" step="0.1" class="form-control" id="prix" name="prix" required>
			</div>
			<div class="mb-3 mt-3">
				<label for="quantite" class="form-label">Quantité :</label> 
				<input type="number"  class="form-control" id="quantite" name="quantite" required>
			</div>
			<div class="mb-3 mt-3">
				<input type="submit"  class="btn btn-primary" value="Ajouter">
			</div>
		</form>

</div>

</body>
</html>