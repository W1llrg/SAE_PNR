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
 * controller pour la page Hippocampe.fxml
 * @author Tristan
 * @version 1.0
 */
public class HippocampeController extends NavigationControls {

    private static final int[] NBMOIS = {31,28,31,30,31,30,31,31,30,31,30,31};
    private Parent root;
    private Stage stage;
    private Scene scene;

    //page Hippocampe
    @FXML
    private ComboBox<String> espece;
    private ObservableList<String> e = FXCollections.observableArrayList("Syngnathus acus", "Hippocampus guttulatus", "Hippocampus Hippocampus", "Entelurus aequoreus");

    @FXML
    private ComboBox<String> sexe;
    private ObservableList<String> s = FXCollections.observableArrayList("Male", "Femelle", "Inconnu");

    @FXML
    private ComboBox<String> typePeche;
    private ObservableList<String> tp = FXCollections.observableArrayList("casierCrevettes", "casierMorgates", "PetitFilet", "verveuxAnguilles");

    @FXML
    private TextField taille;

    @FXML
    private ComboBox<Integer> gestant;
    private ObservableList<Integer> g =FXCollections.observableArrayList(0,1);

    @FXML
    private TextField temperature;

    @FXML
    private Button ajoutDonneButton;

    @FXML
    private Label errTailleEtLieu;

    // page Hippocampe Lieu
    @FXML
    private Button suivantLieu;

    @FXML
    private Label errLieu;

    @FXML
    private TextField coordX;
    private double x;

    @FXML
    private TextField coordY;
    private double y;

    @FXML
    private Label errDate;

    @FXML
    private TextField date;
    private String d;

    @FXML
    private TextField heure;
    private String h;

    // page Hippocampe Observateur
    @FXML
    private Button suivantObservateur;

    @FXML 
    private Button addObs;

    @FXML
    private TextField nom;
    private ArrayList<Integer> observateur;

    @FXML
    private TextField prenom;

    @FXML
    private Label errAddObs;



    /**
     * Ajoute les donnees saisie dans la base de donne
     * @param e
     */
    @FXML
    private void ajoutDonne(ActionEvent event)throws IOException{
        
        
        try{

            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_pnr", "pnr", "mdp_pnr");
            Statement stmt = c.createStatement();
            String sql1 = "INSERT INTO Lieu VALUES("+this.x+", "+this.y+");";
            int i =  stmt.executeUpdate(sql1);
            if (i > 0) {
                System.out.println("data insérer");
            } else {
                System.out.println("data non insérer");
            }

            String sql2 = "SELECT idObs FROM Observation GROUP BY idObs HAVING COUNT(*) = ( SELECT MAX(mycount) FROM( SELECT COUNT(idObs) mycount FROM  Observation GROUP BY idObs ) o );";
            ResultSet res = stmt.executeQuery(sql2);
            int idObs =0;
            if(res.next()) idObs = res.getInt("idObs")+1;

            String sql3;

            if(d.equals("") && h.equals("")){
                sql3 = "INSERT Observation VALUES("+idObs+",'"+null+"','"+null+"'',"+this.x+", "+this.y+");";
            }else if(d.equals("")){
                sql3 = "INSERT Observation VALUES("+idObs+",'"+null+"','"+this.h+"'',"+this.x+", "+this.y+");";
            }else if(h.equals("")){
                sql3 = "INSERT Observation VALUES("+idObs+",'"+this.d+"','"+null+"'',"+this.x+", "+this.y+");";
            }else{
                sql3 = "INSERT Observation VALUES("+idObs+",'"+this.d+"','"+this.h+"'',"+this.x+", "+this.y+");";
            }
            
            i= stmt.executeUpdate(sql3);
            if (i > 0) {
                System.out.println("data insérer");
            } else {
                System.out.println("data non insérer");
            }

            String sql4="";    
            if(this.espece.getValue()!=null && this.sexe.getValue()!=null && this.typePeche.getValue()!=null && this.gestant.getValue()!=null && !this.taille.getText().equals("") && !this.temperature.getText().equals("") && HippocampeController.valideDouble(this.temperature.getText()) && HippocampeController.valideDouble(this.taille.getText())){
                String espece = (String) this.espece.getValue();
                String sexe = (String) this.sexe.getValue();
                String typePeche = (String) this.typePeche.getValue();
                String taille = this.taille.getText();
                int gestant = (int) this.gestant.getValue();
                String temp = this.temperature.getText();
    
                sql4 = "INSERT Obs_Hippocampe VALUES("+idObs+",'"+espece+"','"+sexe+"',"+ Double.parseDouble(temp)+", '"+typePeche+"',"+ Double.parseDouble(taille)+",'"+ gestant+"');";    
            }

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

            if(this.temperature.getText().equals("") && HippocampeController.valideDouble(this.temperature.getText())){
                sql4+="null,";
            }else if(!this.temperature.getText().equals("") && !HippocampeController.valideDouble(this.temperature.getText())){
                this.errTailleEtLieu.setText("Erreur - temperature invalide");
            }else {
                String temp = this.temperature.getText();
                sql4+=""+Double.parseDouble(temp)+",";
            }


            if(this.typePeche.getValue()==null){
                sql4+="null,";
            }else{
                String typePeche = (String) this.typePeche.getValue();
                sql4+="'"+typePeche+"',";
            }

            if(this.taille.getText().equals("") && HippocampeController.valideDouble(this.taille.getText())){
                sql4+="null,";
            }else if(!this.taille.getText().equals("") && !HippocampeController.valideDouble(this.taille.getText())){
                this.errTailleEtLieu.setText("Erreur - taille invalide");
            }else{
                String taille = this.taille.getText();
                sql4+=Double.parseDouble(taille)+",";
            }


            if(this.gestant.getValue()==null){
                sql4+="null,);";
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
            String sqlRes="SELECT * FROM Observateur, Observation , AObserver, Obs_Hippocampe WHERE idObservateur = lobservateur AND idObs = lobservation AND idObs = obsH";
            System.out.println("valeur :\n"+stmt.executeQuery(sqlRes));

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        switchScene(event, "../vue/Hippocampe.fxml");
    }
    

    /**
     * 
     * @param event
     */
    @FXML
    private void nextPageLieu(ActionEvent event) throws IOException{
        if(HippocampeController.valideDouble(this.coordX.getText()) && HippocampeController.valideDouble(this.coordY.getText())){
            this.errLieu.setText("");
            this.errDate.setText("");
            this.x = Double.parseDouble(this.coordX.getText());
            this.y = Double.parseDouble(this.coordY.getText());

            boolean dateConforme= true;
            String str=this.date.getText();
            if(str.length()!=10) dateConforme=false;
            else if(!Character.isDigit(str.charAt(0)) || !Character.isDigit(str.charAt(1)) || !Character.isDigit(str.charAt(2)) || !Character.isDigit(str.charAt(3)) || str.charAt(4)!='-' || !Character.isDigit(str.charAt(5)) || !Character.isDigit(str.charAt(6)) || str.charAt(7)!='-' || !Character.isDigit(str.charAt(8)) || !Character.isDigit(str.charAt(9)) || Integer.parseInt(str.charAt(5)+str.charAt(6)+"")>12 && Integer.parseInt(str.charAt(5)+str.charAt(6)+"")>HippocampeController.NBMOIS[Integer.parseInt(str.charAt(5)+str.charAt(6)+"")-1]){
                dateConforme=false;
            }


            str=this.heure.getText();
            boolean heureConforme= true;
            if(str.length()!=8) heureConforme=false;
            else if(!Character.isDigit(str.charAt(0)) || !Character.isDigit(str.charAt(1)) || str.charAt(2)!=':' || !Character.isDigit(str.charAt(3)) || !Character.isDigit(str.charAt(4)) || str.charAt(5)!=':' || !Character.isDigit(str.charAt(6)) || !Character.isDigit(str.charAt(7)) || Integer.parseInt(str.charAt(0)+str.charAt(1)+"")>=24 || Integer.parseInt(str.charAt(3)+str.charAt(4)+"")>=60 && Integer.parseInt(str.charAt(5)+str.charAt(6)+"")>=60){
                heureConforme=false;
            }
            
            
            if(heureConforme && dateConforme){
                this.d=this.date.getText();
                this.h=this.heure.getText();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../vue/HippocampeObservateur.fxml"));
                this.root = loader.load();
                
                HippocampeController hippo = loader.getController();
                hippo.setDataLieu(this.x,this.y,this.d,this.h);
    
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
     * 
     * @param x
     * @param y
     * @param d
     * @param h
     */
    private void setDataLieu(double x,double y,String d, String h) {
        this.x=x;
        this.y=y;
        this.d=d;
        this.h=h;
        this.observateur=new ArrayList<Integer>();
    }




    /**
     * 
     * @param event
     */
    @FXML
    private void addObs(ActionEvent event){
        if(!this.nom.getText().equals("") && !this.prenom.getText().equals("")){
            try {
                
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_pnr", "pnr", "mdp_pnr");
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
     * 
     * @param event
     */
    @FXML
    private void nextPageObservateur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vue/Hippocampe.fxml"));
        this.root = loader.load();
        
        HippocampeController hippo = loader.getController();
        hippo.setDataObservateur(this.x,this.y,this.d,this.h,this.observateur);

        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * 
     * @param x
     * @param y
     * @param d
     * @param h
     * @param obs
     */
    private void setDataObservateur(double x,double y,String d, String h,ArrayList<Integer> obs) {
        this.x=x;
        this.y=y;
        this.d=d;
        this.h=h;
        this.observateur=obs;
        this.espece.setItems(this.e);
        this.sexe.setItems(this.s);
        this.gestant.setItems(this.g);
        this.typePeche.setItems(this.tp);
    }

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
