package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 * controller pour la page Hippocampe.fxml
 * @author Tristan
 * @version 1.0
 */
public class HippocampeController extends NavigationControls {

    private Parent root;
    private Stage stage;
    private Scene scene;

    //page Hippocampe
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

    // page Hippocampe Lieu
    @FXML
    Button suivantLieu;

    @FXML
    Label errLieu;

    @FXML
    TextField coordX;
    double x;

    @FXML
    TextField coordY;
    double y;

    @FXML
    Label errDate;

    @FXML
    TextField date;
    String d;

    @FXML
    TextField heure;
    String h;

    // page Hippocampe Observateur
    @FXML
    Button suivantObservateur;

    @FXML 
    Button addObs;

    @FXML
    TextField nom;
    ArrayList<String> lastName;

    @FXML
    TextField prenom;
    ArrayList<String> name;



    /**
     * Ajoute les donnees saisie dans la base de donne
     * @param e
     */
    @FXML
    private void ajoutDonne(ActionEvent event)throws IOException{
        String espece = this.espece.getText();
        String sexe = this.sexe.getText();
        String typePeche = this.typePeche.getText();
        String gestant = this.gestant.getText();
        String temp = this.temperature.getText();
        

        System.out.println("espece : "+espece+"\nsexe : "+sexe+"\ntypePeche : "+typePeche+"\ngestant : "+gestant+"\ntemp : "+temp+"\nX : "+this.x);
    }
    

    /**
     * 
     * @param event
     */
    @FXML
    private void nextPageLieu(ActionEvent event) throws IOException{
        //System.out.println((this.coordX.getText().chars().allMatch( Character::isDigit ) && this.coordY.getText().chars().allMatch( Character::isDigit ))+"");
        if(this.coordX.getText().chars().allMatch( Character::isDigit ) && this.coordY.getText().chars().allMatch( Character::isDigit )){
            this.errLieu.setText("");
            this.errDate.setText("");
            this.x = Double.parseDouble(this.coordX.getText());
            this.y = Double.parseDouble(this.coordY.getText());

            boolean dateConforme= true;
            String str=this.date.getText();
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i)) && (i!=4 || i!=7)) {
                    dateConforme = false;
                }else if(str.charAt(i)!='-' && (i==4 || i==7)){
                    dateConforme = false;
                }
            }

            str=this.heure.getText();
            boolean heureConforme= true;
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i)) && (i!=2 || i!=5)) {
                    heureConforme = false;
                }else if(str.charAt(i)!=':' && (i==2 || i==5)){
                    heureConforme = false;
                }
            }
            
            if(heureConforme && dateConforme){
                this.h=this.heure.getText();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../vue/HippocampeObservateur.fxml"));
                this.root = loader.load();
                
                HippocampeController h = loader.getController();
                h.setDataLieu(this.x,this.y,this.d,this.h);
    
                this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                this.scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{
                this.errDate.setText("Erreur - Forma non comforme");
            }
            

            
        }else{
            this.errLieu.setText("Erreur - Lamber 93 invalide");
        }
        
            
    }

    private void setDataLieu(double x,double y,String d, String h) {
        this.x=x;
        this.y=y;
        this.d=d;
        this.h=h;
    }


    /**
     * 
     * @param event
     */
    @FXML
    private void addObs(ActionEvent event){

    }

    /**
     * 
     * @param event
     */
    @FXML
    private void nextPageObservateur(ActionEvent event) throws IOException {
        double x = this.x;
        System.out.println(x+"");
        switchScene(event, "../vue/Hippocampe.fxml");
        this.x= x;
    }
}
