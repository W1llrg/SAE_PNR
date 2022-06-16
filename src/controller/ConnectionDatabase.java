package controller;

import java.sql.*;

/**
 * une classe qui permet la connexion a la base de donnees du pnr
 * @author William, Evah
 * @version 1.1
 */
public class ConnectionDatabase {
    
    /* la connexion a la base de donnees */
    Connection c;

    /* verification de la connexion */
    boolean isConnected = true;

    /**
     * constructeur, initialise la connexion
     */
    public ConnectionDatabase(String user, String password) {

        try {
            
            this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_pnr", user, password);

            //consulter bdd 
            //Statement stmt = c.createStatement();
            //ResultSet res = stmt.executeQuery("commande sql");

        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
            this.isConnected = false;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            this.isConnected = false;

        }
    }

    /**
     * @return la connexion a la bdd
     */
    public Connection getConnection(){

        return this.c;

    }

    /**
     * applique une nouvelle connexion
     * @param e la nouvelle connexion a appliquer
     */
    public void setConnection(Connection e){

        if (e == null) System.err.println("Erreur : ConnectionDatabase : setConnection() : parametre invalide");
        else this.c = e;

    }
}
