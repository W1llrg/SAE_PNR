package modele;

import modele.donnee.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
/**
 * une classe qui effectue les tests necessaires sur le package donnee
 * @author All
 * @version 1.0
 */
public class ScenarioDonnee{
    /**
    * Constitue le main de la classe
    * @param args tableau de String
    */
    public static void main(String[] args){
        //Observateurs
        Observateur obs1 = new Observateur(1, "Jean", "Pierre");
        Observateur obs2 = new Observateur(2, "Anne", "Bourbigot");
        Observateur obs3 = new Observateur(3, "Theo", "CasseBurne");
        ArrayList<Observateur> observateurs = new ArrayList<Observateur>();
        observateurs.add(obs1);
        observateurs.add(obs2);
        observateurs.add(obs3);

        //Test ObsHippocampe
        Date date = new Date(2022,5,18);
        Time heure = new Time(11,2,12);
        Lieu lieu = new Lieu(123454.32,234211.2354);
        
        //Creation de l'objet ObsHippocampe
        ObsHippocampe newObsHippocampe = new ObsHippocampe(1, date, heure, lieu, observateurs, 23.3, Peche.CASIER_CREVETTES, EspeceHippocampe.SYNGNATHUS_ACUS, Sexe.MALE);
        

        //Test ObsBatracien
        //Creation du tableau regroupant le nombre d'individu pour chaque espece
        int nombreAdultes = 4;
        int nombreAmplexus = 6;
        int nombreTetard = 1900;
        int nombrePonte = 19;
        int[] tabBatracien = new int[4];
        tabBatracien[0] = nombreAdultes;
        tabBatracien[1] = nombreAmplexus;   
        tabBatracien[2] = nombreTetard; 
        tabBatracien[3] = nombrePonte;

        //Creation de l'objet ObsBatracien
        ObsBat    ObsBatracien testBatracien = new ObsBatracien(1, date, heure, lieu, observateurs, tabBatracien, EspeceBatracien.CALAMITE);

        //Test ObsLoutre 




        //Test ObsChouette
       ObsChouette newObsChouette = new ObsChouette(1,date,heure,lieu, observateurs, TypeObservation.SONORE);
       
       
       Chouette newChouette = new Chouette(1,Sexe.FEMELLE,EspeceChouette.HULOTTE);

    
    }
}

