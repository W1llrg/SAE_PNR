package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConnectionController {

    @FXML
    Label statusLabel;

    @FXML
    Button loginButton;

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private void login(ActionEvent event) throws IOException {

        String user = this.username.getText();
        String passwd = this.password.getText();

        ConnectionDatabase c = new ConnectionDatabase(user, passwd);

        if (c.isConnected) {
            
            this.statusLabel.setText("connexion reussie");

            // changement de page
            switchScene(event, "../vue/HomePage.fxml");
            

        } else {
            
            this.statusLabel.setText("Connexion refusee");

        }
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
