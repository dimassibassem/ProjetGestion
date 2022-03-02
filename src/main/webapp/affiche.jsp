<%@page import="java.util.List" %>
<%@page import="com.example.projetgestion.dao.Produit" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
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
<% List<Produit> l = (List<Produit>) request.getAttribute("listeP"); %>

<div class="container mt-4">
    <h1>Liste des produits</h1>
    <div class="my-3">
        <a href="addProduit" class="btn btn-primary">Ajouter un nouveau produit</a>
    </div>
    <div>
        <form method="POST" action="findProduits">
        <input type="search" name="motle"/>
            <input type="submit" value="Rechercher"/>
        </form>
    </div>
    <table class="table table-hover">
        <tr>
            <th>#</th>
            <th>NOM</th>
            <th>PRIX</th>
            <th>QUANTITE</th>

        </tr>
        <% for (Produit p : l) { %>
        <tr>
            <td><%= p.getId() %>
            </td>
            <td><%= p.getNom() %>
            </td>
            <td><%= p.getPrix() %>
            </td>
            <td><%= p.getQuantite() %>
            </td>
            <td>
                <a href="deleteProduit?id=<%= p.getId() %>" onclick="return confirm('Vouler vous vraiment supprimer?')"
                   class="btn btn-danger">Supprimer</a>
                <a href="editProduit?id=<%= p.getId() %>" class="btn btn-primary">Modifier</a>
            </td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>