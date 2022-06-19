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
 * @author William
 * @version 1.0
 */
public class NavigationControls {
    
    private Parent root;
    private Stage stage;
    private Scene scene;


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

        switchScene(event, "../vue/NewAccount.fxml");
            
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

}
