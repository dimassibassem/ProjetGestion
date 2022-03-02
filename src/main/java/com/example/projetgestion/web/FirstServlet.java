package com.example.projetgestion.web;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.projetgestion.dao.GestionProduitImp;
import com.example.projetgestion.dao.IGestionProduit;
import com.example.projetgestion.dao.Produit;


@WebServlet(urlPatterns = {"/listeProduits", "/addProduit", "/deleteProduit", "/editProduit"})
public class FirstServlet extends HttpServlet {


    IGestionProduit gestion;

    public void init() throws ServletException {
        gestion = new GestionProduitImp();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath(); //retourne l'url pattern d'appel de la servlet
        if (path.equals("/listeProduits")) {
            List<Produit> liste = gestion.getAllProduits();
            request.setAttribute("listeP", liste);
            request.getRequestDispatcher("affiche.jsp").forward(request, response);
        } else if (path.equals("/addProduit")) {
            request.getRequestDispatcher("ajout.jsp").forward(request, response);
        } else if (path.equals("/deleteProduit")) {
            String id = request.getParameter("id");
            gestion.supprProduit(Integer.parseInt(id));
            response.sendRedirect(request.getContextPath() + "/listeProduits");
        } else if (path.equals("/editProduit")) {
            String id = request.getParameter("id");
            Produit produit = gestion.rechercheParId(Integer.parseInt(id));
            request.setAttribute("produit", produit);
            request.getRequestDispatcher("modif.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/addProduit")) {
            String nom = request.getParameter("nom");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            gestion.ajoutProduit(new Produit(nom, prix, quantite));
            response.sendRedirect(request.getContextPath() + "/listeProduits");
        } else if (path.equals("/editProduit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            gestion.modifProduit(new Produit(id, nom, prix, quantite));
            response.sendRedirect(request.getContextPath() + "/listeProduits");
        }
    }

}