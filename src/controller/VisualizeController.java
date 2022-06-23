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
 * Classe controller de la page Visualize.fxml
 * @author William
 * @vesion 1.0
 */
public class VisualizeController extends NavigationControls {
    
    protected Parent root;
    private Stage stage;
    private Scene scene;

    /**
     * emmene vers la page Batracien.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToBatracien(ActionEvent e) throws IOException {

        String sql="SELECT idObs,dateObs,heureObs,lieu_Lambert_X,lieu_Lambert_Y,idObservateur,nom,prenom,idVege,natureVege,vegetation,decrit_LieuVege,zh_id,zh_temporaire,zh_profondeur,zh_surface,zh_typeMare,zh_pente,zh_ouverture,obsB,espece,nombreAdultes,nombreAmplexus,nombrePonte,nombreTetard,temperature,meteo_ciel,meteo_temp,meteo_vent,meteo_pluie FROM Observation, Observateur, AObserve , Vegetation, ZoneHumide, Obs_Batracien WHERE idObservateur=lobservateur AND idObs= lobservation AND obsB=idObs AND concerne_ZH=zh_id AND concernes_vege=idVege";
        

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vue/VisualizeBatracien.fxml"));
        this.root = loader.load();
        
        VisualizeEspeceController batracien = loader.getController();
        batracien.buildData(ConnectionDatabase.getConnection(),sql);
        this.stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * emmene vers la page Loutre.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToLoutre(ActionEvent e) throws IOException {

        switchScene(e, "../vue/VisualizeLoutre.fxml");        

    }

    /**
     * emmene vers la page Hippocampe.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToHippocampe(ActionEvent e) throws IOException {

        switchScene(e, "../vue/VisualizeHippocampe.fxml");

    }

    /**
     * emmene vers la page GCI.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToGCI(ActionEvent e) throws IOException {

        switchScene(e, "../vue/VisualizeGCI.fxml");

    }

    /**
     * emmene vers la page Chouette.fxml
     * @param e signal d'appui du bouton
     * @throws IOException
     */
    public void goToChouette(ActionEvent e) throws IOException {

        switchScene(e, "../vue/VisualizeChouette.fxml");

    }
}
