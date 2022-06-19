package controller;

import java.io.IOException;
import javafx.event.ActionEvent;

/**
 * controller pour la page newAccount.fxml
 */
public class AccountController extends NavigationControls {
    
    public void goToUser(ActionEvent e) throws IOException {

        switchScene(e, "../vue/newAccountPage2.fxml");

    }

    public void goToAdmin(ActionEvent e) throws IOException {

        switchScene(e, "../vue/newAccountPage2.fxml");

    }
}
