package controller;

import java.io.IOException;

import javafx.event.ActionEvent;

/**
 * Classe controler de la page Parametre
 * @author William
 * @version 1.0
 */
public class SettingsController extends NavigationControls {

    public void goToChangePassword(ActionEvent e) throws IOException {

        switchScene(e, "../vue/ChangePassword.fxml");

    }
}