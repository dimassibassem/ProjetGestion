package com.example.projetgestion.dao;

public record Produit(Integer id, String nom, double prix, int quantite) {
    public Produit(Integer id, String nom, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Produit(String nom, double prix, int quantite) {
        this(null, nom, prix, quantite);
    }
}
