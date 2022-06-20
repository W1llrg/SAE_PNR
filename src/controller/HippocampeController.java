package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 * controller pour la page Hippocampe.fxml
 * @author Tristan
 * @version 1.0
 */
public class HippocampeController extends NavigationControls {


    @FXML
    TextField espece;

    @FXML
    TextField sexe;

    @FXML
    TextField typePeche;

    @FXML
    TextField taille;

    @FXML
    TextField gestant;

    @FXML
    TextField temperature;

    @FXML
    Button ajoutDonneButton;

    /**
     * Ajoute les donnees saisie dans la base de donne
     * @param e
     */
    @FXML
    private void ajoutDonne(ActionEvent event){
        String espece = this.espece.getText();
        String sexe = this.sexe.getText();
        String typePeche = this.typePeche.getText();
        String gestant = this.gestant.getText();
        String temp = this.temperature.getText();

        System.out.println("espece : "+espece+"\nsexe : "+sexe+"\ntypePeche : "+typePeche+"\ngestant : "+gestant+"\ntemp : "+temp);
    }
    
}
