package com.example.projetgestion.dao;

public class Produit {

    private int id;
    private String nom;
    private double prix;
    private int quantite;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit(int id, String nom, double prix, int quantite) {
        super();
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }
    public Produit(String nom, double prix, int quantite) {
        super();
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }
    public Produit() {
    }
    @Override
    public String toString() {
        return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + "]";
    }

}