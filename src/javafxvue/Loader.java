package javafxvue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Loader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Page de Connection");
        Pane myPane =(Pane)FXMLLoader.load(Loader.class.getResource("ConnectionPage.fxml"));
        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        
        launch(args);

    }
    

}

