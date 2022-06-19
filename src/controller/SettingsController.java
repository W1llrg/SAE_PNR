package controller;

import java.io.IOException;

import javafx.event.ActionEvent;

/**
 * SettingsController
 */
public class SettingsController extends NavigationControls {

    public void goToChangePassword(ActionEvent e) throws IOException {

        switchScene(e, "../vue/ChangePassword.fxml");

    }
}