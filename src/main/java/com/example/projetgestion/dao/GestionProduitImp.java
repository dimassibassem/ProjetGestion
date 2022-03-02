package com.example.projetgestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionProduitImp implements IGestionProduit {
    Connection connection = ConnexionBD.getConnection();

    @Override
    public void ajoutProduit(Produit p) {
        try {
            var sql = "INSERT INTO produit (nom, prix, quantite) VALUES (?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getNom());
            stm.setDouble(2, p.getPrix());
            stm.setInt(3, p.getQuantite());
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprProduit(int id) {
        try {
            var sqlDelete = "DELETE FROM produit WHERE id=?";
            PreparedStatement stm = connection.prepareStatement(sqlDelete);
            stm.setInt(1, id);
            stm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produit rechercheParId(int id) {
        try {
            var sqlSelectOne = "SELECT * FROM produit WHERE id=?";
            PreparedStatement stm = connection.prepareStatement(sqlSelectOne);
            stm.setInt(1, id);
            var res = stm.executeQuery();
            if (res.next()) {
                return new Produit(
                        res.getInt(1),
                        res.getString(2),
                        res.getDouble(3),
                        res.getInt(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Produit> getAllProduits() {
        try {
            var sqlSelect = "SELECT * FROM produit";
            PreparedStatement stm = connection.prepareStatement(sqlSelect);

            var res = stm.executeQuery();
            var list = new ArrayList<Produit>();
            while (res.next()) {
                list.add(new Produit(
                        res.getInt(1),
                        res.getString(2),
                        res.getDouble(3),
                        res.getInt(4)));
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Produit> getProduitParNom(String nom) {
        try {
            var sqlSelect = "SELECT * FROM produit where nom like ?";
            PreparedStatement stm = connection.prepareStatement(sqlSelect);
            stm.setString(1, '%' + nom + '%');

            var res = stm.executeQuery();
            var list = new ArrayList<Produit>();
            while (res.next()) {
                list.add(new Produit(
                        res.getInt(1),
                        res.getString(2),
                        res.getDouble(3),
                        res.getInt(4)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void modifProduit(Produit p) {
        try {
            var sql = "UPDATE produit SET nom=?, prix=?, quantite=?  WHERE id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getNom());
            stm.setDouble(2, p.getPrix());
            stm.setInt(3, p.getQuantite());
            stm.setInt(4, p.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
