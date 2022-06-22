package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * controller pour la page ConnectionPage.fxml
 * @author William
 * @version 1.0
 */
public class ConnectionController {

    @FXML
    Label statusLabel;

    @FXML
    Button loginButton;

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    /** connexion a la base de donnees */
    private ConnectionDatabase connected;

    private Parent root;
    private Stage stage;
    private Scene scene;

    private String validUser;
    private String validPasswd;


    /**
     * teste la connexion a la BDD et passe a la page suivante si la connexion est valide. Sinon, affiche un message de refus de connexion
     * @param event recupere le signal envoye par le bouton de connexion
     * @throws IOException
     */
    @FXML
    private void login(ActionEvent event) throws IOException {

        String user = this.username.getText();
        String passwd = this.password.getText();

        this.validUser = user;
        this.validPasswd = passwd;

        ConnectionDatabase c = new ConnectionDatabase(user, passwd);

        if (c.isConnected) {
            
            this.statusLabel.setText("connexion reussie");

            // changement de page
            switchScene(event, "../vue/HomePage.fxml");
            
        } else {
            
            this.statusLabel.setText("Connexion refusee");

            // debug
            // switchScene(event, "../vue/HomePage.fxml");

        }
    }

    public String getUser() {

        return this.validUser;

    }

    
    public String getPassword() {

        return this.validPasswd;

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
}
