package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Class controller pour la page Batracien.fxml
 * @author William 
 * @version 1.0 
 */
public class BatracienController extends NavigationControls {

    private static final int[] NBMOIS = {31,28,31,30,31,30,31,31,30,31,30,31};
    private Parent root;
    private Stage stage;
    private Scene scene;

    //page hippocampe
    /**
     * Combobox contenant la liste des espece de batraciens
     */
    @FXML
    private ComboBox<String> espece;

    /**
     * Liste des espece de batraciens
     */
    private ObservableList<String> listEspece = FXCollections.observableArrayList("calamite", "pelodyte");

    /**
     * Combox contenant les type de ciel
     */
    @FXML
    private ComboBox<String> ciel;

    /**
     * Liste des types de ciel
     */
    private ObservableList<String> listCiel = FXCollections.observableArrayList("dégagé", "semi-dégagé", "nuageux");

    /**
     * Combobox contenant la température
     */
    @FXML
    private ComboBox<String> temp;

    /**
     * Liste des types de température
     */
    private ObservableList<String> listTemp = FXCollections.observableArrayList("froid", "moyen", "chaud");

    /**
     * Combox des types de vent
     */
    @FXML
    private ComboBox<String> vent;

    /**
     * Liste des types de vent
     */
    private ObservableList<String> listVent = FXCollections.observableArrayList("non", "léger", "moyen", "fort");

    /**
     * Combox des types de pluie
     */
    @FXML
    private ComboBox<String> pluie;

    /**
     * Liste des types de pluie
     */
    private ObservableList<String> listPluie= FXCollections.observableArrayList("non", "légère", "moyenne", "forte");

    
    /**
     * Zone de texte pour le nombre de tetards
     */
    @FXML
    private TextField nbTetard;

    /**
     * Zone de texte pour le nombre de pontes
     */
    @FXML
    private TextField nbPontes;
    
    /**
     * Zone de texte pour le nombre d'amplexus
     */
    @FXML
    private TextField nbAmplexus;
    
    /**
     * Zone de texte pour le nombre d'adultes
     */
    @FXML
    private TextField nbAdultes;
    
    /**
     * Zone de texte pour la temperature de l'eau
     */
    @FXML
    private TextField tempEau;

    /**
     * Zone de texte pour la zone temporaire
     */
    @FXML
    private TextField zoneTmp;

    /**
     * Zone de texte pour la profondeur
     */
    @FXML
    private TextField profondeur;

    /**
     * Zone de texte pour la surface
     */
    @FXML
    private TextField surface;

    /**
     * Zone de texte pour le type de la mare
     */
    @FXML
    private ComboBox<String> typeMare;

    /**
     * Liste des types de mares
     */
    private ObservableList<String> listMares = FXCollections.observableArrayList("Prairie", "Etang", "Mare", "Marais");

    /**
     * Zone de texte pour l'ouverture
     */
    @FXML
    private ComboBox<String> ouverture;

    /**
     * Liste des types d'ouvertures
     */
    private ObservableList<String> listOuvertures = FXCollections.observableArrayList("Abritée", "Ouverte");

    /**
     * Zone de texte pour la pente
     */
    @FXML
    private ComboBox<String> pente;

    /**
     * Liste des types de pentes
     */
    private ObservableList<String> listPentes = FXCollections.observableArrayList("Raide", "Abrupte", "Douce");

    /**
     * zone de texte pour le lieuVege decrit
     */
    @FXML
    private TextField lieuVege;

    /**
     * zone de texte pour le lieuVege decrit
     */
    @FXML
    private ComboBox<String> nomVegetation;

    /**
     * Liste des noms de vegetation
     */
    private ObservableList<String> listVege = FXCollections.observableArrayList("Prairie,Culture,Fourrés", "Prairie", "Autres", "Fourrés,Autres", "Prairie,Fourrés", 
    "Prairie,Fourrés,Autres", "Culture", "Fourrés", "Culture,Fourrés,Autres", "Prairie,Culture", "Prairie,Autres", "Culture,Autres");

    /**
     * zone de texte pour le lieuVege decrit
     */
    @FXML
    private ComboBox<String> natureVegetation;

    /**
     * Liste des natures de vegetation
     */
    private ObservableList<String> listNature = FXCollections.observableArrayList("environnement", "bordure");

    /**
     * Bouton pour l'ajout de donnee 
     */
    @FXML
    private Button ajoutDonneButton;

    /** 
     * Label d'erreur 
     */ 
    @FXML
    private Label errLabel;

    // page Batracien Lieu 
    /**
     * Bouton suivant pour le lieu
     */
    @FXML
    private Button suivantLieu;

    /**
     * Label d'erreur du mauvais lieu 
     */
    @FXML
    private Label errLieu;

    /**
     * Zone de texte pour la coordonee X
     */
    @FXML
    private TextField coordX;

    /**
     * coordonee X en Double
     */
    private double x;

    /**
     * Zone de texte de la coordonee Y
     */
    @FXML
    private TextField coordY;

    /**
     * coordonee Y en Double
     */
    private double y;

    /**
     * Label de l'erreur de la mauvaise date
     */
    @FXML
    private Label errDate;

    /**
     * Zone de texte de la date
     */
    @FXML
    private TextField date;

    /**
     * String de la date
     */
    private String d;

    /**
     * Zone de texte de l'heure
     */
    @FXML
    private TextField heure;

    /**
     * String de l'heure
     */
    private String h;

    // page Batracien Observateur
    /**
     * Bouton suivant de la page observateur
     */
    @FXML
    private Button suivantObservateur;

    /**
     * Bouton d'ajout d'observateur 
     */
    @FXML 
    private Button addObs;

    /**
     * Zone de texte du nom de l'observateur
     */
    @FXML
    private TextField nom;

    /**
     * Liste des observateur
     */
    private ArrayList<Integer> observateur;

    /**
     * Zone de texte du prenom de l'observateur
     */
    @FXML
    private TextField prenom;

    /**
     * Label d'erreur de l'ajout d'un observateur erronee 
     */
    @FXML
    private Label errAddObs;


    /**
     * Ajoute les donnees saisie dans la base de donne
     * @param event un actionEvent 
     */
    @FXML
    private void ajoutDonnees(ActionEvent event) throws IOException {
        
        
        try{

            Connection c = ConnectionDatabase.getConnection();
            Statement stmt = c.createStatement();
            String sql0="SELECT * FROM Lieu WHERE coord_Lambert_X=" + this.x + " AND coord_Lambert_Y=" + this.y;
                ResultSet resLieu =  stmt.executeQuery(sql0);
                boolean lieuExitePas =true;

                if(resLieu.next()) lieuExitePas=false;

                int i;

                if(lieuExitePas) {

                    String sql1 = "INSERT INTO Lieu VALUES("+this.x+", "+this.y+");";
                    i =  stmt.executeUpdate(sql1);
                    if (i > 0) {
                        System.out.println("data insérée");
                    } else {
                        System.out.println("data non insérée");
                    }

                }

            String sql2 = "SELECT MAX(idObs) FROM Observation;";
            ResultSet res = stmt.executeQuery(sql2);
            int idObs =0;
            if(res.next()) idObs = res.getInt("MAX(idObs)")+1;

            String sql3;

            if(d.equals("") && h.equals("")){
                sql3 = "INSERT Observation VALUES("+idObs+","+null+","+null+","+this.x+", "+this.y+");";
            }else if(d.equals("")){
                sql3 = "INSERT Observation VALUES("+idObs+","+null+",'"+this.h+"',"+this.x+", "+this.y+");";
            }else if(h.equals("")){
                sql3 = "INSERT Observation VALUES("+idObs+",'"+this.d+"',"+null+","+this.x+", "+this.y+");";
            }else{
                sql3 = "INSERT Observation VALUES("+idObs+",'"+this.d+"','"+this.h+"',"+this.x+", "+this.y+");";
            }
            
            i= stmt.executeUpdate(sql3);
            if (i > 0) {
                System.out.println("data insérée");
            } else {
                System.out.println("data non insérée");
            }

            String sql4="";    
            
            // insertion espece
            if(this.espece.getValue()==null){
                sql4+="INSERT Obs_Batracien VALUES("+idObs+",null,";
            }else {
                String espece = (String) this.espece.getValue();
                sql4 +="INSERT Obs_Batracien VALUES("+idObs+",'"+espece+"'," ;
            }

            // insertion nbAdultes
            if(this.nbAdultes.getText() == null) {
                sql4 += "null,";
            } 
            else if(!this.nbAdultes.getText().equals("") && !BatracienController.valideInt(this.nbAdultes.getText())) {

                this.errLabel.setText("Erreur - nombre d'adultes invalide");

            }
            else {

                String nbAdultes = (String) this.nbAdultes.getText();
                 sql4+= nbAdultes + ",";

            }

            // insertion nbAmplexus
            if(this.nbAmplexus.getText() == null) {
                sql4 += "null,";
            } 
            else if(!this.nbAmplexus.getText().equals("") && !BatracienController.valideInt(this.nbAmplexus.getText())) {

                this.errLabel.setText("Erreur - nombre d'adultes invalide");

            }
            else {

                String nbAmplexus = (String) this.nbAmplexus.getText();
                 sql4 += nbAmplexus + ",";

            }

            // insertion nbPontes
            if(this.nbPontes.getText() == null) {
                sql4 += "null,";
            } 
            else if(!this.nbPontes.getText().equals("") && !BatracienController.valideInt(this.nbPontes.getText())) {

                this.errLabel.setText("Erreur - nombre de pontes invalide");

            }
            else {

                String nbPontes = (String) this.nbPontes.getText();
                 sql4+= nbPontes + ",";

            }

            // insertion nbTetard
            if(this.nbTetard.getText() == null) {
                sql4 += "null,";
            } 
            else if(!this.nbTetard.getText().equals("") && !BatracienController.valideInt(this.nbTetard.getText())) {

                this.errLabel.setText("Erreur - nombre de tetards invalide");

            }
            else {

                String nbTetard = (String) this.nbTetard.getText();
                 sql4 += nbTetard + ",";

            }

            // insertion temperature eau
            if(this.tempEau.getText() == null) {
                sql4 += "null,";
            } 
            else if(!this.tempEau.getText().equals("") && !BatracienController.valideDouble(this.tempEau.getText())) {

                this.errLabel.setText("Erreur - temperature de l'eau invalide");

            }
            else {

                String tempEau = (String) this.tempEau.getText();
                 sql4 += tempEau + ",";

            }

            // insertion meteo_ciel
            if(this.ciel.getValue() == null) {
                sql4 += "null,";
            }else {
                String ciel = (String) this.ciel.getValue();
                sql4+="'" + ciel + "',";
            }

            // insertion meteo_temp
            if(this.temp.getValue() == null) {
                sql4 += "null,";
            }else {
                String temp = (String) this.temp.getValue();
                sql4+="'" + temp + "',";
            }

            // insertion meteo_vent
            if(this.vent.getValue() == null) {
                sql4 += "null,";
            }else {
                String vent = (String) this.vent.getValue();
                sql4+="'" + vent + "',";
            }

            // insertion meteo_pluie
            if(this.pluie.getValue() == null) {
                sql4 += "null,";
            }else {
                String pluie = (String) this.pluie.getValue();
                sql4+="'" + pluie + "',";
            }

            // recuperation de l'id max dans zonehumide
            String sql41 = "SELECT MAX(zh_id) FROM Zonehumide;";
            ResultSet exec41 = stmt.executeQuery(sql41);
            int idZH =0;
            if(exec41.next()) idZH = exec41.getInt("MAX(zh_id)") + 1;

            // recuperation de l'id max dans vegetation
            String sql42 = "SELECT MAX(idVege) FROM vegetation;";
            ResultSet exec42 = stmt.executeQuery(sql42);
            int idVege =0;
            if(exec42.next()) idVege = exec42.getInt("MAX(idVege)") + 1;
            
            // insertion concerne_ZH
            sql4 += idZH + ",";

            // insertion concernes_Vege
            sql4 += idVege + "); ";

            
            // insertion zoneTmp dans zoneHumide
            String sql6 = "";
            if(this.zoneTmp.getText() == null) {
                sql6 += "INSERT zonehumide VALUES("+idZH+",null,";
            } 
            else if(!this.zoneTmp.getText().equals("") && !BatracienController.valideInt(this.zoneTmp.getText())) {

                this.errLabel.setText("Erreur - zone temporaire invalide");

            }
            else {

                String zoneTmp = (String) this.zoneTmp.getText();
                 sql6+= "INSERT zonehumide VALUES(" + idZH + "," + zoneTmp + ",";

            }

            // insertion profondeur dans zoneHumide
            if(this.profondeur.getText() == null) {
                sql6 += "null,";
            } 
            else if(!this.profondeur.getText().equals("") && !BatracienController.valideDouble(this.profondeur.getText())) {

                this.errLabel.setText("Erreur - profondeur invalide");

            }
            else {

                String profondeur = (String) this.profondeur.getText();
                 sql6+= profondeur + ",";

            }

            // insertion surface dans zoneHumide
            if(this.surface.getText() == null) {
                sql6 += "null,";
            } 
            else if(!this.surface.getText().equals("") && !BatracienController.valideDouble(this.surface.getText())) {

                this.errLabel.setText("Erreur - surface invalide");

            }
            else {

                String surface = (String) this.surface.getText();
                 sql6+= surface + ",";

            }

            // insertion type de la mare dans zoneHumide
            if(this.typeMare.getValue() == null) {
                sql6 += "null,";
            } 
            else {

                String typeMare = (String) this.typeMare.getValue();
                 sql6+= "'" + typeMare + "',";

            }

            // insertion pente dans zoneHumide
            if(this.pente.getValue() == null) {
                sql6 += "null,";
            } 
            else {

                String pente = (String) this.pente.getValue();
                 sql6+= "'" + pente + "',";

            }

            // insertion ouvertures dans zoneHumide
            if(this.ouverture.getValue() == null) {
                sql6 += "null,";
            } 
            else {

                String ouverture = (String) this.ouverture.getValue();
                 sql6+= "'" + ouverture + "'); ";

            }

            // insertion dans la table
            System.out.println(sql6);
            i= stmt.executeUpdate(sql6);
            if (i > 0) {
                System.out.println("data insérée");
            } else {
                System.out.println("data non insérée");
            }

            // insertion idVege + natureVegetation dans vegetation
            String sql7 = "";
            if(this.natureVegetation.getValue() == null) {
                sql7 += "INSERT vegetation VALUES("+idVege+",null,";
            } 
            else {

                String natureVegetation = (String) this.natureVegetation.getValue();
                 sql7+= "INSERT vegetation VALUES(" + idVege + ",'" + natureVegetation + "',";

            }

            // insertion nomVegetation dans vegetation
            if(this.nomVegetation.getValue() == null) {
                sql7 += "null,";
            } 
            else {

                String nomVegetation = (String) this.nomVegetation.getValue();
                 sql7+= "'" + nomVegetation + "',";

            }

            // recuperation de l'id max dans vegetation
            String sql71 = "SELECT MAX(idVegeLieu) FROM lieu_vegetation;";
            ResultSet exec71 = stmt.executeQuery(sql71);
            int lieuVege =0;
            if(exec71.next()) lieuVege = exec71.getInt("MAX(idVegeLieu)") + 1;

            // insertion lieuVege
            sql7 += lieuVege + "); ";


            // insertion dans lieu_vegetation
            String sql8 = "";
            sql8 += "INSERT lieu_vegetation VALUES (" + lieuVege + "); ";

            // insertion dans la table
            System.out.println(sql8);
            i= stmt.executeUpdate(sql8);
            if (i > 0) {
                System.out.println("data insérée");
            } else {
                System.out.println("data non insérée");
            }

            // insertion dans la table vegetation
            System.out.println(sql7);
            i= stmt.executeUpdate(sql7);
            if (i > 0) {
                System.out.println("data insérée");
            } else {
                System.out.println("data non insérée");
            }

            // insertion dans la table Obs_Batracien 
            System.out.println(sql4);
            i= stmt.executeUpdate(sql4);
            if (i > 0) {
                System.out.println("data insérée");
            } else {
                System.out.println("data non insérée");
            }

            for(Integer o : this.observateur){
                String sql5 = "INSERT AObserve VALUES("+o.intValue()+","+idObs+");";
                i=stmt.executeUpdate(sql5);
                if (i > 0) {
                    System.out.println("data insérée");
                } else {
                    System.out.println("data non insérée");
                }
            }




        } catch (Exception e) {
            
            e.printStackTrace();
        }

        switchScene(event, "../vue/NewEntry.fxml");
    }
    

    /**
     * methode permetant de changer de page et de sauvegarder les donnée saisie dans la prochaine page 
     * @param event un ActionEvent
     */
    @FXML
    private void nextPageLieu(ActionEvent event) throws IOException{
        if(BatracienController.valideDouble(this.coordX.getText()) && BatracienController.valideDouble(this.coordY.getText())){
            this.errLieu.setText("");
            this.errDate.setText("");
            this.x = Double.parseDouble(this.coordX.getText());
            this.y = Double.parseDouble(this.coordY.getText());

            boolean dateConforme= true;
            String str=this.date.getText();
            if(!this.date.getText().equals("")){
                if(str.length()!=10) dateConforme=false;
                else if(!Character.isDigit(str.charAt(0)) || !Character.isDigit(str.charAt(1)) || !Character.isDigit(str.charAt(2)) || !Character.isDigit(str.charAt(3)) || str.charAt(4)!='-' || !Character.isDigit(str.charAt(5)) || !Character.isDigit(str.charAt(6)) || str.charAt(7)!='-' || !Character.isDigit(str.charAt(8)) || !Character.isDigit(str.charAt(9))){
                    String[] res = str.split("-");
                    if(Integer.parseInt(res[1])>12 || Integer.parseInt(res[1])<=0 || Integer.parseInt(res[3])>BatracienController.NBMOIS[Integer.parseInt(res[1])-1] || Integer.parseInt(res[3])<=0){
                        dateConforme=false;
                    }
                }
            }


            str=this.heure.getText();
            boolean heureConforme= true;
            if(!this.heure.getText().equals("")){
                if(str.length()!=8) heureConforme=false;
                else if(!Character.isDigit(str.charAt(0)) || !Character.isDigit(str.charAt(1)) || str.charAt(2)!=':' || !Character.isDigit(str.charAt(3)) || !Character.isDigit(str.charAt(4)) || str.charAt(5)!=':' || !Character.isDigit(str.charAt(6)) || !Character.isDigit(str.charAt(7))){
                    String[] res = str.split(":");
                    if(Integer.parseInt(res[0])>23 || Integer.parseInt(res[1])>59 || Integer.parseInt(res[3])>59 || Integer.parseInt(res[0])<0 || Integer.parseInt(res[1])<0 || Integer.parseInt(res[3])<0){
                        heureConforme=false;
                    }
                }
            }
            
            
            if(heureConforme && dateConforme){
                this.d=this.date.getText();
                this.h=this.heure.getText();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../vue/BatracienObservateur.fxml"));
                this.root = loader.load();
                
                BatracienController bat = loader.getController();
                bat.setDataLieu(this.x,this.y,this.d,this.h);
    
                this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                this.scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{
                this.errDate.setText("Erreur - Format non comforme ");
            }
            

            
        }else{
            this.errLieu.setText("Erreur - Lamber 93 invalide");
        }
        
            
    }


    /**
     * Setter de lieu 
     * @param x un Double de la coordonée X
     * @param y un Double de la coordonée Y
     * @param d un String de la Date
     * @param h un String de l'heure
     */
    private void setDataLieu(double x,double y,String d, String h) {
        this.x=x;
        this.y=y;
        this.d=d;
        this.h=h;
        this.observateur=new ArrayList<Integer>();
    }




    /**
     * methode pour ajouter un observateur
     * @param event un ActionEvent 
     */
    @FXML
    private void addObs(ActionEvent event){
        if(!this.nom.getText().equals("") && !this.prenom.getText().equals("")){
            try {
                this.errAddObs.setText("");
                Connection c = ConnectionDatabase.getConnection();
                Statement stmt = c.createStatement();
                String sql1 = "SELECT idObservateur, UPPER(nom) FROM Observateur;";
                ResultSet res =  stmt.executeQuery(sql1);
                boolean trouve =false; 
                int max =0;
                while(res.next() && !trouve){
                if(res.getString("UPPER(nom)")!=null && res.getString("UPPER(nom)").equals(this.nom.getText().toUpperCase())){
                        trouve =true;
                        this.observateur.add(res.getInt("idObservateur"));
                }
                if(max<res.getInt("idObservateur")) max=res.getInt("idObservateur");
                }

                if(!trouve){
                    String sql2 = "INSERT INTO Observateur (idObservateur, nom, prenom) VALUES("+(max+1)+",'"+this.nom.getText()+"','"+this.prenom.getText()+"');";
                    int i = stmt.executeUpdate(sql2);
                    if (i > 0) {
                        System.out.println("data insérée");
                    } else {
                        System.out.println("data non insérée");
                    }
                    this.observateur.add(max+1);
                }

                this.nom.clear();
                this.prenom.clear();

            } catch (Exception e) {
                
                e.printStackTrace();

            }
        }else{
            this.errAddObs.setText("Erreur - champ vide pour le nom ou le prenom ");
        }
    }



    /**
     * methode permetant de changer de page tout en sauvegardant les donnée saisi pour l'observateur
     * @param event un ActionEvent
     */
    @FXML
    private void nextPageObservateur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vue/Batracien.fxml"));
        this.root = loader.load();
        
        BatracienController bat = loader.getController();
        bat.setDataObservateur(this.x,this.y,this.d,this.h,this.observateur);

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * Setter d'observateur
     * @param x un Double de la coordonée X
     * @param y un Double de la coordonée Y
     * @param d un String de la Date
     * @param h un String de l'heure
     * @param obs une ArrayList de Int contenant des observateur
     */
    private void setDataObservateur(double x,double y,String d, String h,ArrayList<Integer> obs) {
        this.x=x;
        this.y=y;
        this.d=d;
        this.h=h;
        this.observateur=obs;
        this.espece.setItems(this.listEspece);
        this.ciel.setItems(this.listCiel);
        this.temp.setItems(this.listTemp);
        this.vent.setItems(this.listVent);
        this.pluie.setItems(this.listPluie);
        this.pente.setItems(this.listPentes);
        this.ouverture.setItems(this.listOuvertures);
        this.typeMare.setItems(this.listMares);
        this.nomVegetation.setItems(this.listVege);
        this.natureVegetation.setItems(this.listNature);
    }

    /**
     * Methode pour verifier si un String est un Double
     * @param str un String
     * @return ret un boolean true si str n'est pas un Double, false dans le contraire
     */
    public static boolean valideDouble(String str) {
        boolean ret =true;
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			ret = false;
		}
		return ret;		
	}

    /**
     * Methode pour verifier si un String est un int
     * @param str un String
     * @return ret un boolean true si str n'est pas un Double, false dans le contraire
     */
    public static boolean valideInt(String str) {
        boolean ret =true;
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			ret = false;
		}
		return ret;		
	}
}
