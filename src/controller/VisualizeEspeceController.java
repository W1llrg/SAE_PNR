package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;



/**
 * Class controller pour les pages de visualisation des especes
 * @author William
 * @version 1.0
 */
public class VisualizeEspeceController extends NavigationControls {
    
    
    private ObservableList<String> data;
    private TableView<String> tableView;


    public void buildData(Connection db, String query) {
        data = FXCollections.observableArrayList();
        query="SELECT idObs,dateObs,heureObs,lieu_Lambert_X,lieu_Lambert_Y,idObservateur,nom,prenom,idVege,natureVege,vegetation,decrit_LieuVege,zh_id,zh_temporaire,zh_profondeur,zh_surface,zh_typeMare,zh_pente,zh_ouverture,obsB,espece,nombreAdultes,nombreAmplexus,nombrePonte,nombreTetard,temperature,meteo_ciel,meteo_temp,meteo_vent,meteo_pluie FROM Observation, Observateur, AObserver , Vegetation, ZoneHumide, Obs_Batracien WHERE idObservateur=lobservateur AND idObs= lobservation AND obsB=idObs AND concerne_ZH=zh_id AND concernes_vege=idVege";
        try{
          //ResultSet
          Statement stmt = db.createStatement();
          ResultSet rs = stmt.executeQuery(query);


          for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
              final int j = i;                
              TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
              col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                  public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                      return new SimpleStringProperty(param.getValue().get(j).toString());                        
                  }                    
              });

              tableView.getColumns().addAll(col); 
          }

          while(rs.next()){
              ObservableList<String> row = FXCollections.observableArrayList();
              for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                String result = rs.getString(i);

                if(result == null) {
                    result = "";
                } 

                row.add(result);
                System.out.println(row);
                  
              }
              data.addAll(row);

          }

          tableView.setItems(data);
          
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");             
        }
        
    }

}
