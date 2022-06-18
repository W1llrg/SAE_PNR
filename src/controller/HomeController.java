package controller;

import java.io.IOException;
import javafx.event.ActionEvent;


/**
 * controller pour la page HomePage.fxml
 * @author William
 */
public class HomeController extends NavigationControls {

    public void logout(ActionEvent event) throws IOException {

        switchScene(event, "../vue/ConnectionPage.fxml");

    }

}
