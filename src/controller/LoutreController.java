package controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.donnee.*;

/**
 * controller pour la page Loutre.fxml
 */
public class LoutreController extends NavigationControls {
    
    @FXML
    TextField lieuDit;

    @FXML
    TextField commune;

    @FXML
    TextField indice;


    public void ajoutDonnees(ActionEvent event) throws IOException {
        
        try {

            // connexion vers la BDD
            Connection c = ConnectionDatabase.getConnection();
            Statement stmt = c.createStatement();
        
            // recuperation observation
            ObsLoutre obs = createObs(IndiceLoutre.POSITIF);

            // insertion dans lieu
            // String insertLieu = "INSERT INTO Lieu VALUES (" + obs.getLieuObs().getXCoord() + ", " + obs.getLieuObs().getYCoord() + "); ";
            // stmt.executeUpdate(insertLieu);

            // insertion dans observation
            String insertObservation = "INSERT INTO Observation VALUES (" + obs.getIdObs() + ", '" + obs.getDateObs() + "', '" + obs.getHeureObs() + "', " 
            + obs.getLieuObs().getXCoord() + ", " + obs.getLieuObs().getYCoord() + "); ";
            stmt.executeUpdate(insertObservation);

            // insertion dans aobserve
            for (Observateur observateur : obs.getLesObservateurs()) {

                String insertAObserve = "INSERT INTO aobserve VALUES (" + obs.getIdObs() + ", " + observateur.getIdObservateur() + "); ";
                stmt.executeUpdate(insertAObserve);
                
            }

            // insertion dans observateur
            for (Observateur observateur : obs.getLesObservateurs()) {

                String insertObservateur = "INSERT INTO Observateur VALUES ('" + observateur.getNom() + "', '" + observateur.prenom() + "'); ";
                stmt.executeUpdate(insertObservateur);
                
            }

            // insertion dans ObsLoutre
            String insertLoutre = "INSERT INTO ObsLoutre VALUES (" + obs.getIdObs() + ", '" + this.commune + "', '" + this.lieuDit + "', '" + obs.getIndice() + "'); ";
            stmt.executeUpdate(insertLoutre);

        } catch (Exception e) {

            e.printStackTrace();

        }


    }

    public ObsLoutre createObs(IndiceLoutre ind) {

        ArrayList<Observateur> al = new ArrayList<Observateur>();
        Observateur observateur = new Observateur(2, "leNom", "lePrenom");
        al.add(observateur);
        Date date = Date.valueOf("2022-02-18");
        Time heure =new Time(System.currentTimeMillis());

        ObsLoutre obs = new ObsLoutre(3, date, heure, new Lieu(121212, 121212121), al, ind);

        return obs;

    }
    
}
