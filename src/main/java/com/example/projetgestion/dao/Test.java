package com.example.projetgestion.dao;

public class Test {
    public static void main(String[] args) {
        GestionProduitImp G = new GestionProduitImp();
        System.out.println(G.getAllProduits());
        System.out.println(G.rechercheParId(2));
       // G.ajoutProduit(new Produit("tv",980,78));
       // G.ajoutProduit(new Produit(4,"ecran",500,7));
        System.out.println(G.getAllProduits());
        //System.out.println(G.getProduitParNom("ec"));
        G.modifProduit(new Produit(4,"valve",1,8));
        System.out.println(G.getAllProduits());

        G.supprProduit(4);
        System.out.println(G.getAllProduits());
    }
}
