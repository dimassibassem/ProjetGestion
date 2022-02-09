package com.example.projetgestion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    private static Connection connection ;

    public ConnexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncomm","root","");
            System.out.println("Connected successfully ");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver problem");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Problem");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            new ConnexionBD();
        }
        return connection;
    }
}
