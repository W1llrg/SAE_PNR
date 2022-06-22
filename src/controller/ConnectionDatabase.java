package controller;

import java.sql.*;

/**
 * une classe qui permet la connexion a la base de donnees du pnr
 * @author William, Evah
 * @version 1.2
 */
public class ConnectionDatabase {
    
    /* la connexion a la base de donnees */
    static Connection c = null;

    /* verification de la connexion */
    boolean isConnected = true;

    /**
     * constructeur, initialise la connexion
     */
    public ConnectionDatabase(String user, String password) {

        try {
            
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_pnr", user, password);

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
    public static Connection getConnection(){

        return c;

    }

    /**
     * applique une nouvelle connexion
     * @param e la nouvelle connexion a appliquer
     */
    public void setConnection(Connection e){

        if (e == null) System.err.println("Erreur : ConnectionDatabase : setConnection() : parametre invalide");
        else c = e;

    }
}
