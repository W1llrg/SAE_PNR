package vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * une classe qui permet de lancer l'application en javaFX avec une page initiale
 * @author William
 * @version 2.0
 */
public class Loader extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        try {

            Parent root = FXMLLoader.load(getClass().getResource("ConnectionPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

    public static void main(String[] args) {
        
        launch(args);

    }
    

}

