package controller;

import java.io.IOException;
import javafx.event.ActionEvent;

/**
 * Class controller pour la page newAccount.fxml
 * @author William 
 * @version 1.0
 */
public class AccountController extends NavigationControls {
    
    /**
     * Methode pour mettre en mode utilisateur
     * @param e un ActionEvent
     * @throws IOException
     */
    public void goToUser(ActionEvent e) throws IOException {

        switchScene(e, "../vue/newAccountPage2.fxml");

    }

    /**
     * Methode pour mettre en mode admin 
     * @param e un ActionEvent
     * @throws IOException
     */
    public void goToAdmin(ActionEvent e) throws IOException {

        switchScene(e, "../vue/newAccountPage2.fxml");

    }
}
