package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * une classe qui permet de lancer l'application en javaFX avec une page initiale
 * @author William, Theo
 * @version 2.1
 */
public class Loader extends Application {

    /**
     * Methode pour lancer l'application
     * @param stage Un Stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        try {

            stage.setTitle("Hippoad PNR");
            Parent root = FXMLLoader.load(getClass().getResource("../vue/ConnectionPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

    /**
     * Methode principal
     * @param args un tableau de String
     */
    public static void main(String[] args) {
        
        launch(args);

    }
    

}

