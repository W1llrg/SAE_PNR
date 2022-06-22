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
 * @author William; Thep
 * @version 1.1
 */
public class ConnectionController {

    /**
     * Label des status 
     */
    @FXML
    Label statusLabel;

    /**
     * Bouton de connexion
     */
    @FXML
    Button loginButton;

    /**
     * Zone de texte du nom d'utilisateur
     */
    @FXML
    TextField username;

    /**
     * Zone de texte du mot de passe, le mot de passe dans la zone de texte est cachee 
     */
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

    /**
     * Getter du nom d'utilisateur en String
     * @return un String du nom de l'utilisateur
     */
    public String getUser() {

        return this.validUser;

    }

    /**
     * Getter du mot de passe
     * @return le String du mot de passe
     */
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
