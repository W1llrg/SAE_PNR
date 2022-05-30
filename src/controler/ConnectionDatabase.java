package controler;

import java.sql.*;

/**
 * une classe qui permet la connexion a la base de donnees du pnr
 * @author William
 * @version 1.0
 */
public class ConnectionDatabase {
    
    /**
     * constructeur, initialise la connexion
     */
    public ConnectionDatabase(String user, String password) {

        try {
            
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_pnr",user, password);
            //consulter bdd
            //Statement stmt = c.createStatement();
            //ResultSet res = stmt.executeQuery("commande sql");

        } catch (SQLException e) {
            
            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}
