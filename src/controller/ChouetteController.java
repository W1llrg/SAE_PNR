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
 * controller pour la page Chouette.fxml
 */
public class ChouetteController extends NavigationControls {
    
    private static final int[] NBMOIS = {31,28,31,30,31,30,31,31,30,31,30,31};
    private Parent root;
    private Stage stage;
    private Scene scene;

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
            if(!this.date.getText().equals("")){
                if(str.length()!=10) dateConforme=false;
                else if(!Character.isDigit(str.charAt(0)) || !Character.isDigit(str.charAt(1)) || !Character.isDigit(str.charAt(2)) || !Character.isDigit(str.charAt(3)) || str.charAt(4)!='-' || !Character.isDigit(str.charAt(5)) || !Character.isDigit(str.charAt(6)) || str.charAt(7)!='-' || !Character.isDigit(str.charAt(8)) || !Character.isDigit(str.charAt(9))){
                    String[] res = str.split("-");
                    if(Integer.parseInt(res[1])>12 || Integer.parseInt(res[1])<=0 || Integer.parseInt(res[3])>ChouetteController.NBMOIS[Integer.parseInt(res[1])-1] || Integer.parseInt(res[3])<=0){
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../vue/HippocampeObservateur.fxml"));
                this.root = loader.load();
                
                HippocampeController hippo = loader.getController();
                this.setDataLieu(this.x,this.y,this.d,this.h);
    
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
     * 
     * @param event
     */
    @FXML
    private void nextPageObservateur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vue/Hippocampe.fxml"));
        this.root = loader.load();
        
        HippocampeController hippo = loader.getController();
        this.setDataObservateur(this.x,this.y,this.d,this.h,this.observateur);

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
