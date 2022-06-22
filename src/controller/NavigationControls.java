package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * une classe qui contient plusieurs methodes de navigation utiles a toutes les pages
 * ainsi que la connexion a la base de donnees
 * @author William
 * @version 1.1
 */
public class NavigationControls implements Initializable {
    
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    private Connection c;
    

    public void goToNewEntry(ActionEvent event) throws IOException {

        switchScene(event, "../vue/NewEntry.fxml");
            
    }

    public void goToVisualize(ActionEvent event) throws IOException {

        switchScene(event, "../vue/Visualize.fxml");
            
    }

    public void goToSettings(ActionEvent event) throws IOException {

        switchScene(event, "../vue/Settings.fxml");
            
    }

    public void goToAccount(ActionEvent event) throws IOException {

        switchScene(event, "../vue/newAccount.fxml");
            
    }

    /**
     * change la page affichee a l'ecran
     * @param event ActionEvent qui recupere l'appui sur le bouton
     */
    public void switchScene(ActionEvent event, String path) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        this.root = loader.load();
        
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * renvoi l'utilisateur sur la page de connexion
     * @param e signal d'appui sur un bouton de deconnexion
     * @throws IOException
     */
    public void logout(ActionEvent e) throws IOException {

        switchScene(e, "../vue/ConnectionPage.fxml");

    }

    /**
     * une methode qui teste la connexion vers la base de donnees
     * debug
     */
    public void isCNull() {

        if (this.c == null) {
            
            System.out.println("pas de connexion");

        } else System.out.println("connexion etablie!");

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        try {
            
            // DEBUG
            // this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_pnr", "pnr", "mdp_pnr");

            this.c = ConnectionDatabase.getConnection();
            isCNull();

        } catch (Exception e) {
            
            e.printStackTrace();

        }
        
    }

}
