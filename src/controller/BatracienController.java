package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
     * Zone de texte pour la temperature
     */
    @FXML
    private TextField temperature;

    /**
     * Bouton pour l'ajout de donnee 
     */
    @FXML
    private Button ajoutDonneButton;

    /** 
     * Label d'erreur de la mauvaise taille et de lieu 
     */ 
    @FXML
    private Label errTailleEtLieu;

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
    private void ajoutDonne(ActionEvent event)throws IOException{
        
        
        try{

            Connection c = ConnectionDatabase.getConnection();
            Statement stmt = c.createStatement();
            String sql1 = "INSERT INTO Lieu VALUES("+this.x+", "+this.y+");";
            int i =  stmt.executeUpdate(sql1);
            if (i > 0) {
                System.out.println("data insérer");
            } else {
                System.out.println("data non insérer");
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
                System.out.println("data insérer");
            } else {
                System.out.println("data non insérer");
            }

            String sql4="";    
            
            if(this.espece.getValue()==null){
                sql4+="INSERT Obs_Hippocampe VALUES("+idObs+",null,";
            }else {
                String espece = (String) this.espece.getValue();
                sql4 +="INSERT Obs_Hippocampe VALUES("+idObs+",'"+espece+"'," ;
            }

            if(this.sexe.getValue()==null){
                sql4+="null,";
            }else{
                String sexe = (String) this.sexe.getValue();
                 sql4+="'"+sexe+"',";
            }

            if(this.temperature.getText().equals("")){
                sql4+="null,";
            }else if(!this.temperature.getText().equals("") && !HippocampeController.valideDouble(this.temperature.getText())){
                this.errTailleEtLieu.setText("Erreur - temperature invalide");
            }else {
                String temp = this.temperature.getText();
                sql4+=temp+",";
            }


            if(this.typePeche.getValue()==null){
                sql4+="null,";
            }else{
                String typePeche = (String) this.typePeche.getValue();
                sql4+="'"+typePeche+"',";
            }

            if(this.taille.getText().equals("")){
                sql4+="null,";
            }else if(!this.taille.getText().equals("") && !HippocampeController.valideDouble(this.taille.getText())){
                this.errTailleEtLieu.setText("Erreur - taille invalide");
            }else{
                String taille = this.taille.getText();
                sql4+=taille+",";
            }


            if(this.gestant.getValue()==null){
                sql4+="null);";
            }else{
                int gestant = (int) this.gestant.getValue();
                sql4+="'"+ gestant+"');";
            }
            
            i= stmt.executeUpdate(sql4);
            if (i > 0) {
                System.out.println("data insérer");
            } else {
                System.out.println("data non insérer");
            }

            for(Integer o : this.observateur){
                String sql5 = "INSERT AObserve VALUES("+o.intValue()+","+idObs+");";
                i=stmt.executeUpdate(sql5);
                if (i > 0) {
                    System.out.println("data insérer");
                } else {
                    System.out.println("data non insérer");
                }
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        switchScene(event, "../vue/BatracienLieu.fxml");
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
                        System.out.println("data insérer");
                    } else {
                        System.out.println("data non insérer");
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
}

}
