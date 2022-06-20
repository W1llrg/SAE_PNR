package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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
public class NavigationControls {
    
    private Parent root;
    private Stage stage;
    private Scene scene;

    /** connexion a la BDD */
    private ConnectionDatabase connect;


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
     * connecte l'application avec la base de donnees
     * @param c la connexion vers la base de donnees souhaitee
     */
    public void setConnection(ConnectionDatabase c) {

        if (c == null) throw new IllegalArgumentException("Erreur : aucune connexion a la base de donnees");
        else this.connect = c;

    }

    /**
     * @return la connexion actuelle a la base de donnees
     */
    public ConnectionDatabase getConnection() {

        return this.connect;

    }

    /**
     * renvoi l'utilisateur sur la page de connexion
     * @param e signal d'appui sur un bouton de deconnexion
     * @throws IOException
     */
    public void logout(ActionEvent e) throws IOException {

        switchScene(e, "../vue/ConnectionPage.fxml");

    }

}
