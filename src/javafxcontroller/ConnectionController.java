package javafxcontroller;

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

    public void login() {

        String user = this.username.getText();
        String passwd = this.password.getText();

        ConnectionDatabase c = new ConnectionDatabase(user, passwd);

        if (c.isConnected) {
            
            this.statusLabel.setText("connexion reussie");

            // changement de page
            try {
                
                switchScene(new ActionEvent());

            } catch (Exception e) {
                
                System.err.println(e.getMessage());

            }

        } else {
            
            this.statusLabel.setText("Connexion refusee");

        }
    }

    public void switchScene(ActionEvent e) throws IOException {

        this.root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
