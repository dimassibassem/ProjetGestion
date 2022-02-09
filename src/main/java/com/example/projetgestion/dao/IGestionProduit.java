package com.example.projetgestion.dao;

import java.util.List;

public interface IGestionProduit {
    void ajoutProduit(Produit p);
    void supprProduit(int id);
    Produit rechercheParId(int id);
    List<Produit> getAllProduits();
    List<Produit> getProduitParNom(String nom);
    void modifProduit(Produit p);
}
