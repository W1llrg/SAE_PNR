package controller;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;


=======
/**
 * Class controller pour les pages de visualisation des especes
 * @author William
 * @version 1.0
 */
>>>>>>> 10961321acf863997601ee6edbe5d371ec26a7c5
public class VisualizeEspeceController extends NavigationControls {
    
    
    private ObservableList<String> data;
    private TableView<String> tableview;


    //CONNECTION DATABASE
    public void buildData(){
          Connection c = ConnectionDatabase.getConnection();
          data = FXCollections.observableArrayList();

          try{

            String SQL = "SELECT * FROM Observation JOIN Obs_Batracien ON idObs = obsB";
            ResultSet rs = c.createStatement().executeQuery(SQL);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn<ObservableList<String>,String> col = new TableColumn<ObservableList<String>,String>(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }

                tableview.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                
                ObservableList<Object> row = FXCollections.observableArrayList();
                for(int i = 1 ; i <= rs.getMetaData().getColumnCount(); i++){
                    
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);
            }

            tableview.setItems(data);

          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
    }

}
