<%@page import="java.util.List" %>
<%@page import="com.example.projetgestion.dao.Produit" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Liste des produits</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-4">
    <h1>Liste des produits</h1>
    <div class="my-3">
        <a href="addProduit" class="btn btn-primary">Ajouter un nouveau produit</a>
    </div>
    <form method="POST" action="findProduit">
        <div class="form-group row">

            <div class="col-sm-10">
                <input type="search" name="motcle" class="form-control" placeholder="Search"/>
            </div>

            <div class="col-sm-2">
                <input type="submit" class="btn btn-warning" value="Rechercher"/>
            </div>
        </div>
    </form>
    <table class="table table-hover">
        <tr>
            <th>#</th>
            <th>NOM</th>
            <th>PRIX</th>
            <th>QUANTITE</th>

        </tr>
        <c:forEach var="p" items="${listeP}">
            <tr>
                <td>${p.id}
                </td>
                <td>${p.nom}
                </td>
                <td>${p.prix}
                </td>
                <td>${p.quantite}
                </td>
                <td>
                    <a href="deleteProduit?id=${p.id}" onclick="return confirm('Vouler vous vraiment supprimer?')"
                       class="btn btn-danger">Supprimer</a>
                    <a href="editProduit?id=${p.id}" class="btn btn-primary">Modifier</a>
                </td>
            </tr>
        </c:forEach>


    </table>
</div>
</body>
</html>