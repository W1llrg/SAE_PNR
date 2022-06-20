package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * controller pour la page ConnectionPage.fxml
 * @author William
 * @version 1.0
 */
public class ConnectionController extends NavigationControls {

    @FXML
    Label statusLabel;

    @FXML
    Button loginButton;

    @FXML
    TextField username;

    @FXML
    PasswordField password;


    /**
     * teste la connexion a la BDD et passe a la page suivante si la connexion est valide. Sinon, affiche un message de refus de connexion
     * @param event recupere le signal envoye par le bouton de connexion
     * @throws IOException
     */
    @FXML
    private void login(ActionEvent event) throws IOException {

        String user = this.username.getText();
        String passwd = this.password.getText();

        ConnectionDatabase c = new ConnectionDatabase(user, passwd);

        if (c.isConnected) {
            
            this.statusLabel.setText("connexion reussie");
            setConnection(c);

            // changement de page
            switchScene(event, "../vue/HomePage.fxml");
            
        } else {
            
            this.statusLabel.setText("Connexion refusee");

            // debug
            //switchScene(event, "../vue/HomePage.fxml");

        }
    }
}
