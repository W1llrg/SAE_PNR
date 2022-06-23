package controller;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



/**
 * Class controller pour les pages de visualisation des especes
 * @author William
 * @version 1.0
 */
public class VisualizeEspeceController extends NavigationControls {
    
    
    private ObservableList<ObservableList<String>> data;

    @FXML
    private TableView<ObservableList<String>> tableView;

    @FXML
    private TableColumn<ObservableList<String>, String> NatureVege;

    @FXML
    private TableColumn<ObservableList<String>, String> date;

    @FXML
    private TableColumn<ObservableList<String>, String> description;

    @FXML
    private TableColumn<ObservableList<String>, String> espece;

    @FXML
    private TableColumn<ObservableList<String>, String> heure;

    @FXML
    private TableColumn<ObservableList<String>, String> id;

    @FXML
    private TableColumn<ObservableList<String>, String> idObservateur;

    @FXML
    private TableColumn<ObservableList<String>, String> idVegetation;

    @FXML
    private TableColumn<ObservableList<String>, String> idZH;

    @FXML
    private TableColumn<ObservableList<String>, String> meteoCiel;

    @FXML
    private TableColumn<ObservableList<String>, String> meteoPluie;

    @FXML
    private TableColumn<ObservableList<String>, String> meteoTemp;

    @FXML
    private TableColumn<ObservableList<String>, String> meteoVent;

    @FXML
    private TableColumn<ObservableList<String>, String> nbAdulte;

    @FXML
    private TableColumn<ObservableList<String>, String> nbAmplexus;

    @FXML
    private TableColumn<ObservableList<String>, String> nom;

    @FXML
    private TableColumn<ObservableList<String>, String> nombrePonte;

    @FXML
    private TableColumn<ObservableList<String>, String> nombreTetard;

    @FXML
    private TableColumn<ObservableList<String>, String> obsB;

    @FXML
    private TableColumn<ObservableList<String>, String> ouvertureZH;

    @FXML
    private TableColumn<ObservableList<String>, String> penteZH;

    @FXML
    private TableColumn<ObservableList<String>, String> prenom;

    @FXML
    private TableColumn<ObservableList<String>, String> profondeurZH;

    @FXML
    private TableColumn<ObservableList<String>, String> srfaceZH;

    @FXML
    private TableColumn<ObservableList<String>, String> tempZH;

    @FXML
    private TableColumn<ObservableList<String>, String> temperature;

    @FXML
    private TableColumn<ObservableList<String>, String> tpMareZH;

    @FXML
    private TableColumn<ObservableList<String>, String> vege;

    @FXML
    private TableColumn<ObservableList<String>, String> x;

    @FXML
    private TableColumn<ObservableList<String>, String> y;
    

    public void buildData(Connection c, String query) {
        data = FXCollections.observableArrayList();
        try{
          //ResultSet
          Statement stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          
          

          //System.out.println(tableView.getColumns()+"");
          while(rs.next()){
              ObservableList<String> row = FXCollections.observableArrayList();
              for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                String result = rs.getString(i);

                if(result == null) {
                    result = "";
                } 

                row.add(result);
                
                  
              }
              data.add(row);

          }
          //System.out.println(data+"");
          tableView.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");             
        }
        
    }

}
